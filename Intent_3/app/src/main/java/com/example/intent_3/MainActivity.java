package com.example.intent_3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_data, edt_res;
    Button btn_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mapping data
        edt_data = findViewById(R.id.edt_data);
        edt_res = findViewById(R.id.edt_res);
        btn_send = findViewById(R.id.btn_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Declare Intent
                Intent myintent = new Intent(MainActivity.this, Result_Activity.class);
                //Get data
                int a = Integer.parseInt(edt_data.getText().toString());
                //Give data to the Intent
                myintent.putExtra("numa", a);
                //Star Intent
                startActivityForResult(myintent,99);

            }
        });

    }
    //Receive result


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int res = data.getIntExtra("res",0);
            edt_res.setText("Value is "+res);
        }

        if(requestCode == 99 && resultCode == 34){
            int res = data.getIntExtra("res", 0);
            edt_res.setText("Value is "+ res);
        }
    }
}