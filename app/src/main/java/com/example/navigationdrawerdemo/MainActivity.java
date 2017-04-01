package com.example.navigationdrawerdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initNavigationView();
    }

    private void initNavigationView(){
        NavigationView navigationView   = (NavigationView) findViewById(R.id.navgation_view);
        drawerLayout  = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.categories:
                        drawerLayout.closeDrawers();
                        Toast.makeText(MainActivity.this, "Categories", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.items:
                        drawerLayout.closeDrawers();
                        Toast.makeText(MainActivity.this, "Items", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.images:
                        drawerLayout.closeDrawers();
                        Toast.makeText(MainActivity.this, "Images", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
