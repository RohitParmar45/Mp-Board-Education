package com.rohitparmar.mpboardeducation;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.snackbar.Snackbar;

import com.rohitparmar.mpboardeducation.Services.NetworkBroadcast;
import com.rohitparmar.mpboardeducation.commerceActivity.commerceMain;
import com.rohitparmar.mpboardeducation.scienceClass.scienceMain;
import com.rohitparmar.mpboardeducation.tenthclass.tenthHome;

// import com.unity3d.ads.UnityAds;

import eu.dkaratzas.android.inapp.update.Constants;
import eu.dkaratzas.android.inapp.update.InAppUpdateManager;
import eu.dkaratzas.android.inapp.update.InAppUpdateStatus;

//import com.google.android.ads.mediationtestsuite.MediationTestSuite;
//import com.google.android.gms.ads.AdError;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.FullScreenContentCallback;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.MobileAds;
//import com.google.android.gms.ads.OnUserEarnedRewardListener;
//import com.google.android.gms.ads.initialization.InitializationStatus;
//import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
//import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
//import com.google.android.gms.ads.rewarded.RewardItem;
//import com.google.android.gms.ads.rewarded.RewardedAd;
//import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
//import com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp.PdfViewActivity;
//import com.rohitparmar.mpboardeducation.tenthclass.tenthMain;
//import us.zoom.sdksample.ui.InitAuthSDKActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener , InAppUpdateManager.InAppUpdateHandler {

    MaterialCardView tenthclicker, scienceclicker, commerceclicker, agclicker;
    InAppUpdateManager inAppUpdateManager;
    private InterstitialAd mInterstitialAd;
    static public  String  textView3; //youtube video fetching
    static public  String zoomLink = " "; //zoomLink
    static public  String subjectFirebase = " "; //online class subjects
    static public  String subjectTimingFirebase = " "; //onlince class subjects timing
    static public  String noteFirebase = " "; //onlince class note / topic / timing other subject
    private SpinKitView spinKitView;
    static public  String myClass= "12" ;
    private BroadcastReceiver broadcastReceiver;

//    private String GAME_ID = "4812205";
//    private String intersticial_unity = "Interstitial_Android";
    private boolean test = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        tenthclicker = findViewById(R.id.tenthclicker);
        scienceclicker = findViewById(R.id.scienceclicker);
        commerceclicker = findViewById(R.id.commerceclicker);
        agclicker = findViewById(R.id.agclicker);
        spinKitView = findViewById(R.id.spin_kit_main);

        tenthclicker.setOnClickListener(this);
        scienceclicker.setOnClickListener(this);
        commerceclicker.setOnClickListener(this);
        agclicker.setOnClickListener(this);


//        UnityAds.initialize(this , GAME_ID , test);
//        loadInterstitial();
        
//        MobileAds.initialize(MainActivity.this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        InterstitialAd.load(this,"ca-app-pub-8065643524026387/4918698617", adRequest,   // test unit id ca-app-pub-3940256099942544/1033173712
//                new InterstitialAdLoadCallback() {
//                    @Override
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        // The mInterstitialAd reference will be null until
//                        // an ad is loaded.
//                        mInterstitialAd = interstitialAd;
//                        Log.i("TAG", "onAdLoaded");
//                    }
//
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error
//                        Log.i("TAG", loadAdError.getMessage());
//                        mInterstitialAd = null;
//                    }
//                });
//
//
//
//        if (mInterstitialAd != null) {
//            mInterstitialAd.show(MainActivity.this);
//        } else {
//            Log.d("TAG", "The interstitial ad wasn't ready yet.");
//        }
//        MediationTestSuite.launch(MainActivity.this);


        //update method code

        broadcastReceiver = new NetworkBroadcast();

        registerReceiver(broadcastReceiver , new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        inAppUpdateManager = InAppUpdateManager.Builder(this, 101)
                .resumeUpdates(true)
                .mode(Constants.UpdateMode.IMMEDIATE)
                .snackBarAction("An update has just been downloaded.")
                .snackBarAction("RESTART")
                .handler(this);


        inAppUpdateManager.checkForAppUpdate();



    }
    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.tenthclicker:

              Intent intent = new Intent(MainActivity.this, tenthHome.class);
              startActivity(intent);
                break;

            case R.id.scienceclicker:

                Intent intent1 = new Intent(MainActivity.this, scienceMain.class);
                startActivity(intent1);

                break;

            case R.id.commerceclicker:

//                if(UnityAds.isInitialized()){
//                    Intent intent2 = new Intent(MainActivity.this, commerceMain.class);
//                    startActivity(intent2);
//                    UnityAds.show(MainActivity.this,intersticial_unity);
//
//                }else{
              Intent intent2 = new Intent(MainActivity.this, commerceMain.class);
             startActivity(intent2);
//                }

                break;

            case R.id.agclicker:
                Toast.makeText(this, "Coming Soon...", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onInAppUpdateError(int code, Throwable error) {

    }

    @Override
    public void onInAppUpdateStatus(InAppUpdateStatus status) {
        if (status.isDownloaded()){

            View view = getWindow().getDecorView().findViewById(android.R.id.content);
            Snackbar snackbar = Snackbar.make(view,
                    "An update has just been downloaded.",
                    Snackbar.LENGTH_INDEFINITE);

            snackbar.setAction("" , new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    inAppUpdateManager.completeUpdate();
                }

            });

            snackbar.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

//
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
    public void onBackPressed() {

    }
}