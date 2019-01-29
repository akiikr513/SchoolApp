package com.example.akiik.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StudentDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dash);

        Bundle bundle=getIntent().getExtras();
    }
}
