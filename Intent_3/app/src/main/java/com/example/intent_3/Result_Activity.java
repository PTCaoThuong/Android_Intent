package com.example.intent_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Result_Activity extends AppCompatActivity {
    EditText edt_rev;
    Button btn_ori, btn_sqr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //Mapping data
        edt_rev = findViewById(R.id.edt_rev);
        btn_ori = findViewById(R.id.btn_ori);
        btn_sqr = findViewById(R.id.btn_sqr);
        //Receive Intent
        Intent myintent = getIntent();
        //Get data from Intent
        int a = myintent.getIntExtra("numa", 0);
        edt_rev.setText(a+"");
        //Press buton 1 to send the original result
        btn_ori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent.putExtra("res",a);
                setResult(33, myintent);
                finish();
            }
        });
        //press button 2 to send the sqare result
        btn_sqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myintent.putExtra("res", a*a);
                setResult(34, myintent);
                finish();
            }
        });

    }
}