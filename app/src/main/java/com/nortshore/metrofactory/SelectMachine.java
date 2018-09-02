package com.nortshore.metrofactory;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SelectMachine extends AppCompatActivity {
    ListView machineListView;
    ArrayAdapter<String> adapter;
    DatabaseReference db;
//    FirebaseHelper helper;
      ArrayList<String> nameList=new ArrayList<>();
    private ArrayAdapter<String> arrayAdapterMach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_machine);

        machineListView = (ListView) findViewById(R.id.machineList);
        //SETUP FIREBASE
        db = FirebaseDatabase.getInstance().getReference();
//        helper = new FirebaseHelper(db.child("sec001"));

        FirebaseDatabase.getInstance().getReference().child("sec001")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        nameList.clear();
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Machine user = snapshot.getValue(Machine.class);
                            System.out.println("NNNNNNNNN" + user.getName());
                            nameList.add(user.getName());
                            System.out.println("BBBBBBBBBB"+nameList.size());
                            adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, nameList){
                                @Override
                                public View getView(int position, View convertView, ViewGroup parent) {
                                    View view = super.getView(position, convertView, parent);
                                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                                    text.setTextColor(Color.BLACK);
                                    text.setTextSize(24);
                                    return view;
                                }
                            };
                            machineListView.setAdapter(adapter);
                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

        machineListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + nameList.get(position), Toast.LENGTH_LONG)
                        .show();
                Intent i = new Intent(SelectMachine.this, MachineStatus.class);
                Bundle bundle=new Bundle();
                bundle.putString("name",nameList.get(position));
                i.putExtras(bundle);
                startActivity(i);
            }
        });

    }
}
