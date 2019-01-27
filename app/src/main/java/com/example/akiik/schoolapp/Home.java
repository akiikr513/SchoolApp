package com.example.akiik.schoolapp;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageView imageView=findViewById(R.id.sc_home);
        Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade);
        imageView.startAnimation(animation);
Thread timer=new Thread(){
    @Override
    public void run() {


        try {


        sleep(2000);
        Intent ihome=new Intent(getApplicationContext(),wellcome.class);
        startActivity(ihome);
        finish();
        super.run();
    } catch (InterruptedException e){
            e.printStackTrace();
        }

    }


};
timer.start();

    }
}
