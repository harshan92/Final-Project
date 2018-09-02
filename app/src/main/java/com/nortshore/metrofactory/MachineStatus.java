package com.nortshore.metrofactory;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MachineStatus extends AppCompatActivity {
    TextView nameTV, tempTV, installedTV, maintainedTV, humidityTV;

    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_status);
        nameTV=findViewById(R.id.nameView);
        installedTV=findViewById(R.id.installedTV);
        maintainedTV=findViewById(R.id.maintainedTV);
        humidityTV=findViewById(R.id.humTV);
        Bundle bundle = getIntent().getExtras();
         name = bundle.getString("name");
        nameTV.setText(name);
        tempTV=findViewById(R.id.tempTV);
        FirebaseDatabase.getInstance().getReference().child("sec001")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Machine machine = snapshot.getValue(Machine.class);
                            if(machine.getName().equals(name)){
                                tempTV.setText(""+machine.getTemp());
                                installedTV.setText(machine.getInstalled());
                                maintainedTV.setText(machine.getMaintained());
                                humidityTV.setText(""+machine.getHum());
                            }


                        }
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

    }
}
