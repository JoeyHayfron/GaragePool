package com.example.mac.garagepool1;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mac.garagepool1.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.*;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMap;


public class MechInfoPage extends AppCompatActivity {

    TextView garagename;
    TextView name_of_owner;
    TextView phone_of_owner;
    TextView email_of_owner;
    public User userss;
    Toolbar mToolbar;


    FirebaseDatabase db;
    DatabaseReference users;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech_info_page);



        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");




        garagename = (TextView)findViewById(R.id.garage_name);
        name_of_owner = (TextView)findViewById(R.id.name_of_owner);
        phone_of_owner = (TextView)findViewById(R.id.phone_of_owner);


        phone_of_owner.setText(getIntent().getExtras().getString("phone"));
        name_of_owner.setText(getIntent().getExtras().getString("name"));
        garagename.setText(getIntent().getExtras().getString("name"));

    }


}
