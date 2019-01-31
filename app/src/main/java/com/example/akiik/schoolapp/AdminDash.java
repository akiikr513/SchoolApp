package com.example.akiik.schoolapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDash extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dash);

        Bundle bundle=getIntent().getExtras();

        Button but_stu=findViewById(R.id.stu);
        Button but_teach=findViewById(R.id.teach);
        Button but_par=findViewById(R.id.par);
        Button but_acc=findViewById(R.id.acc);
        Button but_lbr=findViewById(R.id.lib);

        but_acc.setOnClickListener(this);
        but_teach.setOnClickListener(this);
        but_stu.setOnClickListener(this);
        but_par.setOnClickListener(this);
        but_lbr.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.teach:
                Intent iteach=new Intent(this,TeacherList.class);
                startActivity(iteach);
                break;
            case R.id.acc:
                Intent iacc=new Intent(this,AccountantList.class);
                startActivity(iacc);
                break;
            case R.id.stu:
                Intent istu=new Intent(this,StudentDetail.class);
                startActivity(istu);
                break;
            case R.id.par:
                Intent ipar=new Intent(this,ParentList.class);
                startActivity(ipar);
                break;
            case R.id.lib:
                Intent ilib=new Intent(this,LiberianList.class);
                startActivity(ilib);
                break;

        }

    }


}
