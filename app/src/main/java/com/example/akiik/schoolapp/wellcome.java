package com.example.akiik.schoolapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
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
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class wellcome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private DrawerLayout drawer;
    ViewPager slide;

DatabaseReference myRef;


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

    //new  changes are done here to onClick some error is here
/*
    @Override
    protected void onStart(){
        super.onStart();
         final TextView textpname=findViewById(R.id.pnamehome);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("school-786");
        myRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot) {
                String text=dataSnapshot.getValue(String.class);
                textpname.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
*/
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

            case R.id.nav_notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new NotificationFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_attendance:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AttendanceFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_assignment:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AssignmentFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CalendarFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_results:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ResultsFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_track_bus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TrackBusFragment()).addToBackStack(null).commit();
                break;

            case R.id.nav_fee_status:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeeStatusFragment()).addToBackStack(null).commit();
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