package com.rohitparmar.mpboardeducation.Premium.LoginPage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rohitparmar.mpboardeducation.MainActivity;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;


public class regDone extends AppCompatActivity {

     private TextView textView3;
     FirebaseFirestore database;
     private MaterialCardView whatsappus;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_done);

        textView3 = findViewById(R.id.referSet3);
         database = FirebaseFirestore.getInstance();
        whatsappus = findViewById(R.id.Whatsappus);

        database.collection("Changeable").document("registrationDone").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
                textView3.setText(String.valueOf(user.getRegistration()));

            }
        });
        SharedPreferences shrdCreditial = getSharedPreferences("credential" , MODE_PRIVATE);
        String localMob = shrdCreditial.getString("mobileNo", "1234567890");

        whatsappus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl = "https://wa.me/+919406807992?text= *Hello Sir* , I want to purchase the Crash Course for 2023 exam. , this is my registered mobile number - "+localMob;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("isFirstTime",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFirstTime", false);
        editor.apply();



    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Successfully Registered...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(regDone.this, MainActivity.class));
    }
}