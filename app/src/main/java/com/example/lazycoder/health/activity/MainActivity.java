package com.example.lazycoder.health.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.lazycoder.health.Database.SampleData;
import com.example.lazycoder.health.R;
import com.example.lazycoder.health.fragment.Accessorise;
import com.example.lazycoder.health.fragment.Doctor;
import com.example.lazycoder.health.fragment.Food;
import com.example.lazycoder.health.fragment.Gym;
import com.example.lazycoder.health.fragment.Home;
import com.example.lazycoder.health.fragment.Medicine;
import com.example.lazycoder.health.fragment.ProductDetailPage;
import com.example.lazycoder.health.interfaces.ClickListener;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ClickListener {

    private RelativeLayout navHomeRl,navDoctorRl,navAccessoriesRl,navMedicineRl,navFoodRl,navGymRl;
    private Fragment mFragment;
    private FragmentTransaction transaction;
    private SearchView simpleSearchView;
    private SampleData sampleData;


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

        transaction.add(R.id.containerMain, mFragment);
        transaction.commit();
    }
    /*
    * initialize  all object or variable
    * */
    private void initializeAll() {

        //insert some sample data
        sampleData = new SampleData(this);
        sampleData.storeSomeSampleData();
        
        mFragment = new Home();
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
                Toast.makeText(getApplicationContext(),query+" ",Toast.LENGTH_LONG).show();

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
                mFragment = new Home();
                break;
            case R.id.navDoctorRl:
                mFragment = new Doctor();
                break;
            case R.id.navAccessoriesRl:
                mFragment = new Accessorise();
                break;
            case R.id.navMedicineRl:
                mFragment = new Medicine();
                break;
            case R.id.navFoodRl:
                mFragment = new Food();
                break;
            case R.id.navGymRl:
                mFragment = new Gym();
                break;

        }

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerMain, mFragment);
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

    //if we use this then addToBackStack won't work need to solution this on later

//
//    /*
//    * after press back button this method will be called
//    * */
//    public void onBackPressed() {
//
//
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                MainActivity.this);
//
//        // set title
//        alertDialogBuilder.setTitle("Exit");
//
//        // set dialog message
//        alertDialogBuilder
//                .setMessage("Do you want to exit?")
//                .setCancelable(false)
//                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        // if this button is clicked, close
//                        // current activity
//                        MainActivity.this.finish();
//                    }
//                })
//                .setNegativeButton("No",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        // if this button is clicked, just close
//                        // the dialog box and do nothing
//                        dialog.cancel();
//                    }
//                });
//
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//        // show it
//        alertDialog.show();
//    }

    public void changeFragment(Fragment fragment){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.containerMain,fragment).addToBackStack(null);

        transaction.commit();
    }

    @Override
    public void onProductClick() {
        changeFragment(new ProductDetailPage());
    }

    @Override
    public void onProductClick(Fragment fragment) {
        changeFragment(fragment);
    }

}
