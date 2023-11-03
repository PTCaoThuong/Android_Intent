package com.example.simple_equation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txt_x;
    Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txt_x = findViewById(R.id.txt_x);
        btn_back = findViewById(R.id.btn_back);
        //nhan intent
        Intent myintent = getIntent();
        // lay bundle ra khoi intent
        Bundle mybundle = myintent.getBundleExtra("mypackage");

        int a = mybundle.getInt("numa");
        int b = mybundle.getInt("numb");
        // tien hanh giai phuong trinh va hien thi ket qua
        String value = "";
        if(a == 0 && b == 0){
            value = "Equation with countless solutions";
        }
        else if(a == 0 && b != 0){
            value = "The equation has no solution";
        }
        else{
            value = "x = " + ((-1.0)*b/a);
        }

        txt_x.setText(value);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}