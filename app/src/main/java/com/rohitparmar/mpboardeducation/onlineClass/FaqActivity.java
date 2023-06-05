package com.rohitparmar.mpboardeducation.onlineClass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.card.MaterialCardView;
import com.rohitparmar.mpboardeducation.MainActivity;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.onlineClass.FaqAnswers.FabAnswer1;
import com.rohitparmar.mpboardeducation.onlineClass.FaqAnswers.FaqAnswer3;
import com.rohitparmar.mpboardeducation.onlineClass.FaqAnswers.faqAnswer2;
import com.rohitparmar.mpboardeducation.onlineClass.FaqAnswers.faqAnswer4;

public class FaqActivity extends AppCompatActivity {
   private MaterialCardView unabletoOpen,wheretheclass,whatHappenafter,howcanIContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        unabletoOpen = findViewById(R.id.unabletoOpen);
        wheretheclass = findViewById(R.id.wheretheclass);
        whatHappenafter = findViewById(R.id.whatHappenafter);
        howcanIContact = findViewById(R.id.howcanIContact);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        unabletoOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(FaqActivity.this, FabAnswer1.class);
                startActivity(intent);
            }
        });

        wheretheclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(FaqActivity.this, faqAnswer2.class);
                startActivity(intent);
            }
        });

        whatHappenafter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(FaqActivity.this, FaqAnswer3.class);
                startActivity(intent);
            }
        });


        howcanIContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(FaqActivity.this, faqAnswer4.class);
                startActivity(intent);
            }
        });

    }
}