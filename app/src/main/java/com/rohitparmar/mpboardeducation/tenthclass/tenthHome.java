package com.rohitparmar.mpboardeducation.tenthclass;

import static com.rohitparmar.mpboardeducation.MainActivity.textView3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.denzcoskun.imageslider.ImageSlider;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import com.rohitparmar.mpboardeducation.LargeFiles.LargeFiles;
import com.rohitparmar.mpboardeducation.LargeFiles.tenth.LargeFileTen;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;

//import com.unity3d.ads.UnityAds;

import java.util.ArrayList;
import java.util.List;

public class tenthHome extends AppCompatActivity  {


    private ImageSlider mainSlider;
    // private AdView mAdView;
    private LottieAnimationView swiperightScience ;
    private SpinKitView spinKitView;
    private MaterialCardView cardView , largeFile;

    private TextView mainHeading1;
    private TextView date1;
    private TextView subject1;
    private TextView body1;

    private String GAME_ID = "4812205";
    private String intersticial_unity = "Interstitial_Android";
    private boolean test = true ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenth_home);

        spinKitView = findViewById(R.id.spin_kittenthHome);
        spinKitView.setVisibility(View.GONE);
        cardView =findViewById(R.id.onlineHomeTenth);
        swiperightScience = findViewById(R.id.mainsub);

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        mainHeading1 = findViewById(R.id.mainheading_noticeten);
        date1 = findViewById(R.id.date_noticehometen);
        subject1 = findViewById(R.id.noticehome_subjectten);
        body1 = findViewById(R.id.noticehome_bodyten);
        largeFile = findViewById(R.id.largeFileTen);


        database.collection("linkingFirstore").document("noticeboardhome").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
                String date = String.valueOf(user.getFee());
                String main_heading = String.valueOf(user.getRegistration());
                String subject = String.valueOf(user.getSubject());
                String body = String.valueOf(user.getDialog1());

                mainHeading1.setText(main_heading);
                date1.setText(date);
                subject1.setText(subject);
                body1.setText(body);

                YoYo.with(Techniques.Bounce).duration(1000).repeat(20).playOn(date1);
                YoYo.with(Techniques.ZoomIn).duration(1000).repeat(1).playOn(mainHeading1);
            }
        });

//        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view_ten);
//        getLifecycle().addObserver(youTubePlayerView);
//
//        try {
//            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
//                @Override
//                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
//                    String videoId =  textView3;
//                    youTubePlayer.loadVideo(videoId, 0);
//                }
//            });
//        }catch (Exception e){
//            Toast.makeText(tenthHome.this, "Error : " + e , Toast.LENGTH_LONG).show();
//        }


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tenthHome.this, OnlineClassMain.class);
                startActivity(intent);
            }
        });


        swiperightScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(UnityAds.isInitialized()){
//                    Intent intent = new Intent(tenthHome.this, tenthMain.class);
//                    startActivity(intent);
//
//                    UnityAds.show(tenthHome.this,intersticial_unity);
//
//                }else{
                    Intent intent = new Intent(tenthHome.this, tenthMain.class);
                    startActivity(intent);
//                }
            }
        });

//        UnityAds.initialize(this , GAME_ID , test);
//        loadInterstitial();

        largeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tenthHome.this, LargeFileTen.class);
                startActivity(intent);
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
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


}
