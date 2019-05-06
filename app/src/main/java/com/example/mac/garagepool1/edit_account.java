package com.example.mac.garagepool1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class edit_account extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    EditText name;
    EditText phone;
    EditText email;
    EditText password;
    Button savechanges;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_edit_account);
        name = findViewById(R.id.name__of_owner);
        phone = findViewById(R.id.phonenumber);
        email = findViewById(R.id.emailaccount);
        password = findViewById(R.id.pword);
        savechanges = findViewById(R.id.savechanges);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");

        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

       final DatabaseReference uid = users.child(auth.getCurrentUser().getUid());
       final DatabaseReference names = uid.child("name");
        final DatabaseReference emails = uid.child("email");
       final  DatabaseReference phones = uid.child("phone");
        final DatabaseReference passwords = uid.child("password");


        uid.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               name.setText(dataSnapshot.child("name").getValue(String.class));
                phone.setText(dataSnapshot.child("phone").getValue(String.class));
                email.setText(dataSnapshot.child("email").getValue(String.class));
                password.setText(dataSnapshot.child("password").getValue(String.class));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.w(TAG, "onCancelled", databaseError.toException());
            }

        });

       savechanges.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               names.setValue(name.getText().toString());
               phones.setValue(phone.getText().toString());
               user.updatePassword(password.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful()) {
                               }
                           }
                       });
               user.updateEmail(email.getText().toString())
                       .addOnCompleteListener(new OnCompleteListener<Void>() {
                           @Override
                           public void onComplete(@NonNull Task<Void> task) {
                               if (task.isSuccessful()) {
                               }
                           }
                       });
               Toast.makeText(edit_account.this,"Changes saved succesfully",Toast.LENGTH_SHORT).show();
           }
       });

    }
}
