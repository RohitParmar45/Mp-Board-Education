package com.rohitparmar.mpboardeducation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.annotation.SuppressLint;

import android.provider.CalendarContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class aboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Element adsElement = new Element();
        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setDescription(" Thank You for Using Our App  ")
                .addItem(new Element().setTitle("Version 5.0"))
                .addGroup(" If you are Facing any type of Problem related to App then Please Contact Us !")
                .addEmail("rohitparmar181589@gmail.com")
                .addWebsite("https://cricketsmartpro.blogspot.com/2021/07/mp-board-education-privacy-policy.html")
                .addYoutube("https://www.youtube.com/channel/UCQ39II8g44RdCp9ZjcRHVOg")   //Enter your youtube link here (replace with my channel link)
                .addPlayStore("com.example.yourprojectname")   //Replace all this with your package name
                .addInstagram("https://www.instagram.com/p/CRl_8W6Lmcg/?utm_medium=copy_link")    //Your instagram id
                .addItem(createCopyright())
                .create();

        setContentView(aboutPage);
    }
    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by MP Board Education ", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(aboutUsActivity.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}