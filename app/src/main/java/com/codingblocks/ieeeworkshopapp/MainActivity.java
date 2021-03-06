package com.codingblocks.ieeeworkshopapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText etKm, etMin;

    Button btnCalc, btnSecAct, btnSensorAct;

    TextView tvFare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        etKm = (EditText) findViewById(R.id.etKm);
        etMin = (EditText) findViewById(R.id.etMin);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        tvFare = (TextView) findViewById(R.id.tvFare);

        btnSecAct = (Button) findViewById(R.id.btnSecAct);
        btnSensorAct = (Button) findViewById(R.id.btnSensor);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float km = Float.valueOf(etKm.getText().toString());
                int min = Integer.valueOf(etMin.getText().toString());

                float fare = calculateFare(km, min);

                tvFare.setText("Rs. " + String.valueOf(fare));




                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Fare")
                        .setMessage("Fare is Rs. " + String.valueOf(fare))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "Paid",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this,
                                        "Did not pay",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();

                new Student().increaseAge().increaseAge().increaseAge();
            }
        });

        btnSecAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        btnSensorAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(i2);
            }
        });
    }



    float calculateFare(float km, int min) {
        float fare = 25;

        if (km > 2) {
            fare += (km * 9);
        }

        if (min > 15) {
            fare += (min - 15);
        }

        return fare;
    }



    public class Student {
        String name;
        int year;
        int age = 10;

        Student increaseAge() {
            age++;
            return this;
        }
        Student decreaseAge() {
            age--;
            return this;
        }
    }

    public interface OnAttendanceListener {
        void onAttendance(boolean present);
    }


    public class CollegeStudent implements OnAttendanceListener {

        @Override
        public void onAttendance(boolean present) {

        }
    }










}
