package com.example.akiik.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class TeacherDash extends AppCompatActivity {
        Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_dash);

        Bundle bundle=getIntent().getExtras();
    }
}
