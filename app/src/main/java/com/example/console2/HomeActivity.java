package com.example.console2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity  {
    Spinner spinner;
    EditText id;
    Button insert, result;
    DBHelper DB;
    int op=1;
TextView op1;
    Timer timer;
    Button log;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        id = findViewById(R.id.idnumber);
        spinner = findViewById(R.id.my_spinner);

        insert = findViewById(R.id.register);
        result = findViewById(R.id.getresult);
        DB = new DBHelper(this);
        log=findViewById(R.id.login);


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomeActivity.this,Loginpage.class);
                startActivity(intent);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                ViewGroup viewGroup = findViewById(android.R.id.content);
                Button ok;
                TextView cancel;



                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                View view1 = LayoutInflater.from(HomeActivity.this).inflate(R.layout.dialogue_layout, viewGroup, false);
                builder.setCancelable(false);
                builder.setView(view1); cancel = view1.findViewById(R.id.cancel);
                ok=view1.findViewById(R.id.ok);




                final AlertDialog alertDialog = builder.create();

                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                  cancel.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {


                      }
                  });

                alertDialog.show();




                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(HomeActivity.this);
                        builder1.setMessage("your op number is:"+op++);
                        AlertDialog alertDialog1 = builder1.create();
                        alertDialog1.show();
                        timer = new Timer();
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(HomeActivity.this, opstatus.class);
                                startActivity(intent);
                                finish();

                            }
                        }, 5000);

                    }
                });






                String idtext = id.getText().toString();
                        String selected_item = spinner.getSelectedItem().toString();
                        Boolean checkinsertdata = DB.insertuserdata(idtext, selected_item);

                        if (checkinsertdata == true) {
                            Toast.makeText(HomeActivity.this, "New entry inserted", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(HomeActivity.this, "New entry not inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                result.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = DB.getdata();
                        if (res.getCount() == 0) {
                            Toast.makeText(HomeActivity.this, "No entry exist", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("id:" + res.getString(0) + "\n");
                            buffer.append("problem:" + res.getString(1) + "\n");

                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
                        builder.setCancelable(true);
                        builder.setTitle("user entries");
                        builder.setMessage(buffer.toString());
                        builder.show();

                    }
                });


                spinner = findViewById(R.id.my_spinner);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selected_item = spinner.getSelectedItem().toString();
                        Toast.makeText(HomeActivity.this, "CHOOSEN:" + selected_item, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }}