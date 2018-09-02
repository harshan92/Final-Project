package com.nortshore.metrofactory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMenu extends AppCompatActivity {
    Button statusBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        statusBtn=findViewById(R.id.statusBtn);
        statusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayStatus();
            }
        });
    }

    public void displayStatus(){
        Intent intent=new Intent(this,SelectMachine.class);
        startActivity(intent);
    }
}
