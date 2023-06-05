package com.rohitparmar.mpboardeducation.commerceActivity.commerceui.homeCom;

//import static com.rohitparmar.mpboardeducation.MainActivity.textView3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
//import com.denzcoskun.imageslider.ImageSlider;
//import com.denzcoskun.imageslider.constants.ScaleTypes;
//import com.denzcoskun.imageslider.interfaces.ItemClickListener;
//import com.denzcoskun.imageslider.models.SlideModel;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
//import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
//import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.FullImageVLottie;
import com.rohitparmar.mpboardeducation.FullImageView;
import com.rohitparmar.mpboardeducation.LargeFiles.Commerce.LargeFileCom;
import com.rohitparmar.mpboardeducation.LargeFiles.LargeFiles;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;
import com.rohitparmar.mpboardeducation.scienceClass.prescienceSubActivity;

import java.util.ArrayList;
import java.util.List;

public class homeComFragment extends Fragment {

    private MaterialCardView cardView ,largeFile;
    LottieAnimationView swiperightCom;
    private SpinKitView spinKitView;

    private TextView mainHeading1;
    private TextView date1;
    private TextView subject1;
    private TextView body1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_com, container, false);

        cardView = view.findViewById(R.id.onlineHomeCom);
        swiperightCom = view.findViewById(R.id.swiperightCom);

        mainHeading1 = view.findViewById(R.id.mainheading_noticecom);
        date1 = view.findViewById(R.id.date_noticehomecom);
        subject1 = view.findViewById(R.id.noticehome_subjectcom);
        body1 = view.findViewById(R.id.noticehome_bodycom);
        largeFile = view.findViewById(R.id.largeFileCom);

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


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OnlineClassMain.class);
                startActivity(intent);
            }
        });

        swiperightCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FullImageVLottie.class);
                startActivity(intent);
            }
        });

        largeFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LargeFileCom.class);
                startActivity(intent);
            }
        });

        return view;
    }


}
