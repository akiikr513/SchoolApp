package com.example.akiik.schoolapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class wellcome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);
        NavigationView navigationView=findViewById(R.id.nav__view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.nav_admin:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AdminFragment()).commit();
                break;
            case R.id.nav_teacher:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new TeacherFragment()).commit();
                break;
            case R.id.nav_parents:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ParentsFragment()).commit();
                break;
            case R.id.nav_student:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new StudentsFragment()).commit();
                break;
            case R.id.nav_accountant:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AccountantFragment()).commit();
                break;
            case R.id.nav_library:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new LibrarianFragment()).commit();
                break;
            case R.id.nav_home:
                    openwellcome();
                    break;

        }

drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    private void openwellcome() {
        Intent iwellcom=new Intent(this,wellcome.class);
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