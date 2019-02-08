package com.example.akiik.schoolapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class wellcome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout drawer;
    ViewPager slide;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);

        Button but_accademics=findViewById(R.id.academics_but);
        Button but_events=findViewById(R.id.events);
        Button but_cocu=findViewById(R.id.cocu);
        Button but_mission=findViewById(R.id.mission);

        but_accademics.setOnClickListener(this);
        but_events.setOnClickListener(this);
        but_cocu.setOnClickListener(this);
        but_mission.setOnClickListener(this);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.nav__view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        slide = (ViewPager) findViewById(R.id.slide);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        slide.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.academics_but:
                Intent iaca=new Intent(this,Achivement.class);
                startActivity(iaca);
                break;
            case R.id.events:
                Intent ieve=new Intent(this,Events.class);
                startActivity(ieve);
                break;
            case R.id.cocu:
                Intent icocu=new Intent(this,Cocu.class);
                startActivity(icocu);
                break;
            case R.id.mission:
                Intent imission=new Intent(this,Mission.class);
                startActivity(imission);
                break;


        }



    }

    public class MyTimerTask extends TimerTask {
        @Override
        public void run() {
            wellcome.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if (slide.getCurrentItem() == 0 )
                    {
                        slide.setCurrentItem(1);

                    }
                    else if (slide.getCurrentItem() == 1 )
                    {
                        slide.setCurrentItem(2);


                    }
                    else
                    {
                        slide.setCurrentItem(0);


                    }


                }
            });
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AdminFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_teacher:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TeacherFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_parents:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ParentsFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_student:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StudentsFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_accountant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AccountantFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_library:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LibrarianFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ContactFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_home:
                openwellcome();
                break;

        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }


    private void openwellcome() {
        Intent iwellcom = new Intent(this, wellcome.class);
        startActivity(iwellcom);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {


            super.onBackPressed();
        }
    }

}