package com.example.akiik.schoolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeacherList extends AppCompatActivity implements View.OnClickListener{
    Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_list);
        but=findViewById(R.id.t_edit_but);
        but.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.t_edit_but){
            Intent it_details=new Intent(this,TeacherDetail.class);
            startActivity(it_details);
        }


    }
}
