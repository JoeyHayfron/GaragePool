
package com.example.mac.garagepool1;

import android.*;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mapbox.services.android.telemetry.permissions.PermissionsManager;

import android.Manifest;


public class SelectUser extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private RadioGroup radioGroup;
    private RadioButton motorist;
    private RadioButton mechanic;
    private  Button mButton;
    static boolean calledAlready = false;
    private static final int READ_SMS_PERMISSIONS_REQUEST = 1;
    private PermissionsManager permissionsManager;
    int PERMISSION_ALL = 1;
    public static boolean signin = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] PERMISSIONS = {Manifest.permission.SEND_SMS, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE};

        if(!hasPermissions(this, PERMISSIONS)){
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        setContentView(R.layout.activity_select_user);



        if (!calledAlready)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("Users");
            scoresRef.keepSynced(true);

            calledAlready = true;
        }

        mechanic = (RadioButton) findViewById(R.id.mech);
        motorist = (RadioButton) findViewById(R.id.motorist);
        mButton = (Button) findViewById(R.id.next);

        loadRadioButtons();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveRadioButtons();

            }
        });
    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }


    public void saveRadioButtons(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if(mechanic.isChecked())
        {
            editor.putBoolean("Mechanic", mechanic.isChecked());
            editor.apply();
            Intent intent = new Intent(SelectUser.this,MainActivity.class);
            startActivity(intent);
        }
        else if(motorist.isChecked())
        {
            editor.putBoolean("Motorist", motorist.isChecked());
            editor.apply();
            Intent intent = new Intent(SelectUser.this,offlinemanager.class);
            startActivity(intent);
        }

    }

    public void loadRadioButtons(){
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        motorist.setChecked(sharedPreferences.getBoolean("Motorist", false));
        mechanic.setChecked(sharedPreferences.getBoolean("Mechanic", false));
        if(mechanic.isChecked() == true)
        {
            Intent intent = new Intent(SelectUser.this,MainActivity.class);
            startActivity(intent);
        }
        else if(motorist.isChecked() == true)
        {
            Intent intent = new Intent(SelectUser.this,offlinemanager.class);
            startActivity(intent);
        }
    }

}
