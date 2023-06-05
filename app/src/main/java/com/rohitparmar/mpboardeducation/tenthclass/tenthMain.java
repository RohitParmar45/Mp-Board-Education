package com.rohitparmar.mpboardeducation.tenthclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.card.MaterialCardView;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.commerceActivity.commerceui.previousCom.PreviousComFragment;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;
import com.rohitparmar.mpboardeducation.scienceClass.Biology.BioPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.Chemistry.ChemPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.EnglishGen.EngGenAPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.EnglishSpec.EngSpecPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.Maths.MathsPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.Physics.PhyPrevious;
import com.rohitparmar.mpboardeducation.scienceClass.prescienceSubActivity;
import com.rohitparmar.mpboardeducation.tenthclass.EnglishX.EngXPrevious;
import com.rohitparmar.mpboardeducation.tenthclass.MathsX.MathsXPrevious;
import com.rohitparmar.mpboardeducation.tenthclass.ScienceX.ScienceXPrevious;
import com.rohitparmar.mpboardeducation.tenthclass.SocialX.SocialXPrevious;

public class tenthMain extends AppCompatActivity implements View.OnClickListener {

    private MaterialCardView MathsX, ScienceX, SocialScienceX, EnglishX,cardOnlineClasses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_main);

        MathsX = findViewById(R.id.twentyX);
        ScienceX = findViewById(R.id.nineteenX);
        SocialScienceX = findViewById(R.id.eighteenX);
        EnglishX = findViewById(R.id.seventeenX);
        cardOnlineClasses=findViewById(R.id.cardOnlineClasses);

        cardOnlineClasses.setOnClickListener(this);
        MathsX.setOnClickListener(this);
        ScienceX.setOnClickListener(this);
        SocialScienceX.setOnClickListener(this);
        EnglishX.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.twentyX:
                Intent intent = new Intent(tenthMain.this, MathsXPrevious.class);
                startActivity(intent);
                break;
            case R.id.nineteenX:
                Intent intent1 = new Intent(tenthMain.this, ScienceXPrevious.class);
                startActivity(intent1);
                break;
            case R.id.eighteenX:
                Intent intent2 = new Intent(tenthMain.this, SocialXPrevious.class);
                startActivity(intent2);
                break;
            case R.id.seventeenX:
                Intent intent3 = new Intent(tenthMain.this, EngXPrevious.class);
                startActivity(intent3);
                break;
            case R.id.cardOnlineClasses :
            Intent intent4 = new Intent(tenthMain.this, OnlineClassMain.class);
            startActivity(intent4);


        }

    }
}