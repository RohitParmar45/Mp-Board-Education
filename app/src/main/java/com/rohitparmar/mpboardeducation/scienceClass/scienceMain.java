package com.rohitparmar.mpboardeducation.scienceClass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

//import com.google.android.gms.ads.AdError;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.FullScreenContentCallback;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.interstitial.InterstitialAd;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
//import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.rohitparmar.mpboardeducation.BuildConfig;
//import com.rohitparmar.mpboardeducation.MainActivity;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.aboutUsActivity;
import com.rohitparmar.mpboardeducation.scienceClass.BluePrintSci.BluePrintsActivity;
import com.rohitparmar.mpboardeducation.scienceClass.Leader.LeaderActivity;
import com.rohitparmar.mpboardeducation.scienceClass.impquestion.impQactivity;
//import com.unity3d.ads.UnityAds;
//import com.unity3d.services.banners.BannerView;


import java.util.Objects;

public class scienceMain extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView bottomNavigationViewScience;
    private NavController navController;
    private DrawerLayout drawerLayoutScience;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationViewScience;

    private String GAME_ID = "4812205";
    private String intersticial_unity = "Interstitial_Android";
    private boolean test = false;

   // private InterstitialAd mInterstitialAd;


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_main);


        bottomNavigationViewScience = findViewById(R.id.bottomNavigationViewScience);
        navController = Navigation.findNavController(this, R.id.frame_layout_science);
        drawerLayoutScience = findViewById(R.id.drawerLayoutScience);
        navigationViewScience = findViewById(R.id.navigation_view_science);


        toggle = new ActionBarDrawerToggle(this, drawerLayoutScience, R.string.start, R.string.close);
        drawerLayoutScience.addDrawerListener(toggle);
        toggle.syncState();


        NavigationUI.setupWithNavController(bottomNavigationViewScience, navController);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationViewScience.setNavigationItemSelectedListener(this);

        navController = Navigation.findNavController(this, R.id.frame_layout_science);
        NavigationUI.setupWithNavController(bottomNavigationViewScience,navController);

          //unity ads [science main , science home , tenthHome]
//        UnityAds.initialize(this , GAME_ID , test);
     //  loadInterstitial();


    }

//    private void loadInterstitial() {
//        if (UnityAds.isInitialized()){
//            UnityAds.load(intersticial_unity);
//        }else{
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    UnityAds.load(intersticial_unity);
//                }
//            }, 5000);
//        }
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:

                Intent intentd = new Intent(scienceMain.this, aboutUsActivity.class);
                startActivity(intentd);
                break;
            case R.id.navigation_share:

                Intent shareIntent1 = new Intent(Intent.ACTION_SEND);
                shareIntent1.setType("text/plain");
                shareIntent1.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                String shareMessage1 = "\n" + "MP Board Education" + "\n\n";
                shareMessage1 = shareMessage1 + "https://play.google.com/store/apps/details?id="  + BuildConfig.APPLICATION_ID + "\n\n" + "download this ";
                shareIntent1.putExtra(Intent.EXTRA_TEXT, shareMessage1);
                startActivity(Intent.createChooser(shareIntent1, "choose one"));

                break;
            case R.id.navigation_rate:
                gotoUrl("https://play.google.com/store/apps/details?id="  + BuildConfig.APPLICATION_ID);
                break;
            case R.id.navigation_youtuber :
                gotoUrl("https://www.youtube.com/channel/UCQ39II8g44RdCp9ZjcRHVOg/videos" + BuildConfig.APPLICATION_ID);
                break;
            case R.id.navigation_blueprint:

                Intent intentb = new Intent(scienceMain.this, BluePrintsActivity.class);
                startActivity(intentb);
                break;

                case R.id.navigation_impquestion:
//                    if(UnityAds.isInitialized()){
                        Intent intente = new Intent(scienceMain.this, impQactivity.class);
                        startActivity(intente);

//                        UnityAds.show(this,intersticial_unity);
//
//                    }else{
//                    Intent intente = new Intent(scienceMain.this, impQactivity.class);
//                startActivity(intente);}
                break;
                case R.id.navigation_LeaderBoard:
                    Intent intentc = new Intent(scienceMain.this, LeaderActivity.class);
                startActivity(intentc);
                break;

        }
        return true;
    }



//    public void setAd(){
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
//            @Override
//            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                // The mInterstitialAd reference will be null until
//                // an ad is loaded.
//                mInterstitialAd = interstitialAd;
//            }
//
//            @Override
//            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                // Handle the error
//                mInterstitialAd = null;
//            }
//        });
//    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
