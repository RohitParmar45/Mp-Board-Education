package com.rohitparmar.mpboardeducation.HindiPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.card.MaterialCardView;
import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.HindiPackage.bhautik.Bhautik;
import com.rohitparmar.mpboardeducation.HindiPackage.blueprints.Blueprints;
import com.rohitparmar.mpboardeducation.HindiPackage.ganit.Ganit;
import com.rohitparmar.mpboardeducation.HindiPackage.jivVIgyan.JivClass;
import com.rohitparmar.mpboardeducation.HindiPackage.pyq.PyqHindi;
import com.rohitparmar.mpboardeducation.HindiPackage.rashayan.Rasayan;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.onlineClass.FaqActivity;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;
import com.rohitparmar.mpboardeducation.onlineClass.faculty.facultyFragment;
import com.rohitparmar.mpboardeducation.onlineClass.telegramMain;
import com.rohitparmar.mpboardeducation.scienceClass.prescienceSubActivity;

public class HindiMain extends AppCompatActivity {
    private MaterialCardView phyHindiMain , chemHindiMain , bioHindiMain , bpHindiMain ,mathHindiMain , pyqHindiMain ;

    private View viewonline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hindi_main);

        phyHindiMain = findViewById(R.id.phyHindiMain);
        chemHindiMain = findViewById(R.id.chemHindiMain);
        bioHindiMain = findViewById(R.id.bioHindiMain);
        mathHindiMain = findViewById(R.id.mathHindiMain);
        bpHindiMain = findViewById(R.id.bpHindiMain);
        pyqHindiMain = findViewById(R.id.pyqHindiMain);


        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        phyHindiMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HindiMain.this , Bhautik.class);
                startActivity(intent);
            }
        });

        chemHindiMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HindiMain.this , Rasayan.class);
                startActivity(intent);
            }
        });

        bioHindiMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HindiMain.this , JivClass.class);
                startActivity(intent);
            }
        });

        mathHindiMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HindiMain.this , Ganit.class);
                startActivity(intent);

            }
        });

        bpHindiMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HindiMain.this , Blueprints.class);
                startActivity(intent);
            }
        });

        pyqHindiMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HindiMain.this , PyqHindi.class);
                startActivity(intent);
            }
        });


    }
}
