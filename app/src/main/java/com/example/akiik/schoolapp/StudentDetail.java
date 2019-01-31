package com.example.akiik.schoolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudentDetail extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        Button add_stu_but=findViewById(R.id.add_stu_but);
        Button s_list_but=findViewById(R.id.s_list_but);
        Button s_edit_but=findViewById(R.id.s_edit_but);


        add_stu_but.setOnClickListener(this);
        s_list_but.setOnClickListener(this);
        s_edit_but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_stu_but:{
                Intent iaddstu=new Intent(this,AddStudent.class);
                startActivity(iaddstu);
            }
            break;
            case R.id.s_list_but:
                Intent istulist=new Intent(this,StudentList.class);
                startActivity(istulist);

                break;
            case R.id.s_edit_but:
                Intent istuedit=new Intent(this,StudentEdit.class);
                startActivity(istuedit);

                break;

    }
}}
