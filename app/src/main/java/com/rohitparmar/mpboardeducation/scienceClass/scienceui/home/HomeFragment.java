package com.rohitparmar.mpboardeducation.scienceClass.scienceui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import com.rohitparmar.mpboardeducation.FullImageVLottie;
import com.rohitparmar.mpboardeducation.HindiPackage.HindiMain;
import com.rohitparmar.mpboardeducation.LargeFiles.LargeFiles;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;


public class HomeFragment extends Fragment {
   // private AdView mAdView;
    private LottieAnimationView swiperightScience ;
   private SpinKitView spinKitView;
    private MaterialCardView cardView , hindiMediumMain, largeFile;
    private String GAME_ID = "4812205";
    private String intersticial_unity = "Interstitial_Android";
    private boolean test = false ;
    private TextView mainHeading1;
    private TextView date1;
    private TextView subject1;
    private TextView body1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_home, container, false);
        spinKitView = view.findViewById(R.id.spin_kitHome);
        spinKitView.setVisibility(View.GONE);
        cardView = view.findViewById(R.id.onlineHome);
        swiperightScience = view.findViewById(R.id.swiperightScience);
        hindiMediumMain = view.findViewById(R.id.hindiMediumMain);
        largeFile = view.findViewById(R.id.largeFileMain);

        mainHeading1 = view.findViewById(R.id.mainheading_notice);
        date1 = view.findViewById(R.id.date_noticehome);
        subject1 = view.findViewById(R.id.noticehome_subject);
        body1 = view.findViewById(R.id.noticehome_body);


        FirebaseFirestore database = FirebaseFirestore.getInstance();
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


//        UnityAds.initialize(getActivity() , GAME_ID , test);
//        loadInterstitial();


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OnlineClassMain.class);
                startActivity(intent);
            }
        });


        swiperightScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

         Intent intent = new Intent( getContext(), FullImageVLottie.class);
                 startActivity(intent);
            }
        });

        hindiMediumMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                if(UnityAds.isInitialized()){
                    Intent intent = new Intent( getContext(), HindiMain.class);
                    startActivity(intent);

 //                UnityAds.show((Activity) getContext(),intersticial_unity);

//                }else{
//                    Intent intent = new Intent( getContext(), HindiMain.class);
//                    startActivity(intent);
//                }


            }
        });


        largeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getContext(), LargeFiles.class);
               startActivity(intent);
            }
        });


        return view;
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
