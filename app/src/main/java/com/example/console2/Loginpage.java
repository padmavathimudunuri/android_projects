package com.example.console2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loginpage extends AppCompatActivity {
Button doctor;
Button administration;
Button admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        doctor=findViewById(R.id.doctor);
        administration=findViewById(R.id.administration);
        admin=findViewById(R.id.admin);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Loginpage.this,Login.class);
                startActivity(intent);
                finish();
            }
        });

        administration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Loginpage.this,Login.class);
                startActivity(intent);
                finish();

            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Loginpage.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}