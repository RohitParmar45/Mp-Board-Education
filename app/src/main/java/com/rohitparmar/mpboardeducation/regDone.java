package com.rohitparmar.mpboardeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.faculty.facultyFragment;

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

        whatsappus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wpurl = "https://wa.me/+919406807992?text=Hello, Sir";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });
    }
}