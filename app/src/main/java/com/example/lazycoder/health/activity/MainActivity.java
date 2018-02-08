package com.example.lazycoder.health.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.lazycoder.health.R;
import com.example.lazycoder.health.fragment.Doctor;
import com.example.lazycoder.health.fragment.Home;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RelativeLayout navHomeRl,navDoctorRl,navAccessoriesRl,navMedicineRl,navFoodRl,navGymRl;
    private Fragment fragment;
    private FragmentTransaction transaction;
    private SearchView simpleSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();
        initializeAll();

        transaction.add(R.id.containerMain,fragment);
        transaction.commit();
    }
    /*
    * initialize  all object or variable
    * */
    private void initializeAll() {
        fragment = new Home();
        transaction = getSupportFragmentManager().beginTransaction();

        navHomeRl = (RelativeLayout) findViewById(R.id.navHomeRl);
        navDoctorRl = (RelativeLayout) findViewById(R.id.navDoctorRl);
        navAccessoriesRl = (RelativeLayout) findViewById(R.id.navAccessoriesRl);
        navMedicineRl = (RelativeLayout) findViewById(R.id.navMedicineRl);
        navFoodRl = (RelativeLayout) findViewById(R.id.navFoodRl);
        navGymRl = (RelativeLayout) findViewById(R.id.navGymRl);

        navHomeRl.setOnClickListener(this);
        navDoctorRl.setOnClickListener(this);
        navAccessoriesRl.setOnClickListener(this);
        navMedicineRl.setOnClickListener(this);
        navFoodRl.setOnClickListener(this);
        navGymRl.setOnClickListener(this);

        simpleSearchView = (SearchView) findViewById(R.id.searchView);
        simpleSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),query+"some thing",Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.navHomeRl:
                fragment = new Home();
                break;
            case R.id.navDoctorRl:
                fragment = new Doctor();
                break;
            case R.id.navAccessoriesRl:
                break;
            case R.id.navMedicineRl:
                break;
            case R.id.navFoodRl:
                break;
            case R.id.navGymRl:
                break;

        }

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerMain,fragment);
        transaction.commit();
        closeDrawer();

    }

    //close navigation drawer
    public void closeDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else if (drawer.isDrawerOpen(GravityCompat.END)){
            drawer.closeDrawer(GravityCompat.END);
        }
    }

    /*
    * after press back button this method will be called
    * */
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                MainActivity.this);

        // set title
        alertDialogBuilder.setTitle("Exit");

        // set dialog message
        alertDialogBuilder
                .setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }
}
