package com.example.simple_equation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_a, edt_b;
    Button btn_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_a = findViewById(R.id.edt_a);
        edt_b = findViewById(R.id.edt_b);
        btn_res = findViewById(R.id.btn_res);

        btn_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent = new Intent(MainActivity.this , ResultActivity.class);
                int a=0;
                int b=0;
                try {
                    a = Integer.parseInt(edt_a.getText().toString());
                    b = Integer.parseInt(edt_b.getText().toString());
                    //Dong goi du lieu trong Bundle, bundle la noi dng goi du lieu de truyen di cho intent

                    Bundle mybundle = new Bundle();
                    //dua du lieu vao bundle
                    mybundle.putInt("numa",a);
                    mybundle.putInt("numb",b);
                    //Dua bundle vao Intent

                    myintent.putExtra("mypackage",mybundle);

                    //khoi dong intent
                    startActivity(myintent);
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Doesn't enter data", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}