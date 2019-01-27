package com.example.akiik.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AdminDash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash);

        Bundle bundle=getIntent().getExtras();

    }
}
