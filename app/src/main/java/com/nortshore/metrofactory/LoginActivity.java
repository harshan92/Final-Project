package com.nortshore.metrofactory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernameView, passwordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton=findViewById(R.id.loginBtn);
        usernameView=findViewById(R.id.usernameET);
        passwordView=findViewById(R.id.passwordET);


        // set login button action
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameView.getText().toString().equals("admin") && passwordView.getText().toString().equals("123")) {
                    diplayDashBoardActivity();
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //create login button method
    public void diplayDashBoardActivity(){

        Intent intent=new Intent(LoginActivity.this, UserMenu.class);
        startActivity(intent);

    }
}
