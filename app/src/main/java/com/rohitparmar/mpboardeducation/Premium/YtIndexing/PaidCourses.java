package com.rohitparmar.mpboardeducation.Premium.YtIndexing;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.android.material.card.MaterialCardView;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;

import java.util.List;
import java.util.Objects;

public class PaidCourses extends AppCompatActivity {
   User user ;
   MaterialCardView physics, chemistry, maths,bio,accounts, bussiness,english,hindi;
    String phyPass = "physics";
    String chemPass= "chemistry";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_courses);
        physics = findViewById(R.id.physicsCourse);
        chemistry = findViewById(R.id.chemistryCourse);
        maths = findViewById(R.id.mathsCourse);
        bio = findViewById(R.id.bioCourse);
        accounts = findViewById(R.id.accountsCourse);
        bussiness = findViewById(R.id.businessCourse);
        english = findViewById(R.id.englishCourse);
        hindi = findViewById(R.id.hindiCourse);

        List< String> list = OnlineClassMain.valList;

       if (list!=null){

           if (!Objects.equals(list.get(1), "0" )&&  !list.get(1).equals("") ){
               physics.setVisibility(View.VISIBLE);
               phyPass = "physics";
           }
           if (!Objects.equals(list.get(2), "0" )&&  !list.get(2).equals("") ){
               chemistry.setVisibility(View.VISIBLE);
               chemPass = "chemistry";
           }
           if (!Objects.equals(list.get(3), "0" ) &&  !list.get(3).equals("") ){
               maths.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(4), "0" )&&  !list.get(4).equals("") ){
               bio.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(5), "0" )&&  !list.get(5).equals("") ){
              phyPass = "physicsHindi";
               physics.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(6), "0" )&&  !list.get(6).equals("") ){
               chemPass = "chemistryHindi";
               chemistry.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(7), "0" )&&  !list.get(7).equals("") ){
               accounts.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(8), "0" )&&  !list.get(8).equals("") ){
               bussiness.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(9), "0" )&&  !list.get(7).equals("") ){
               english.setVisibility(View.VISIBLE);
           }
           if (!Objects.equals(list.get(10), "0" )&&  !list.get(8).equals("") ){
               hindi.setVisibility(View.VISIBLE);
           }


           physics.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , phyPass);
                   startActivity(intent);
               }
           });
           chemistry.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , chemPass);
                   startActivity(intent);
               }
           });
           maths.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , "maths");
                   startActivity(intent);
               }
           });
           bio.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , "bio");
                   startActivity(intent);
               }
           });
           accounts.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , "accounts");
                   startActivity(intent);
               }
           });
           bussiness.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , "business");
                   startActivity(intent);
               }
           });
           hindi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , "hindi");
                   startActivity(intent);
               }
           });
           english.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(PaidCourses.this, YtIndexing.class);
                   intent.putExtra("pdfUrl" , "english");
                   startActivity(intent);
               }
           });


       }

        SharedPreferences shrdCreditial = getSharedPreferences("credential" , MODE_PRIVATE);
        String localMob = shrdCreditial.getString("mobileNo", "6265604260");
        Toast.makeText(this, "mob."+ localMob, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
         startActivity(new Intent(PaidCourses.this, OnlineClassMain.class));
        super.onBackPressed();

    }
}