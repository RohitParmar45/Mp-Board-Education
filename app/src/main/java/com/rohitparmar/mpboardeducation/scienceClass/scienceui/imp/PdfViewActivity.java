package com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import com.google.android.gms.ads.AdRequest;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;

import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.krishna.fileloader.FileLoader;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.ybq.android.spinkit.SpinKitView;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;
import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.MainActivity;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.FaqActivity;
import com.rohitparmar.mpboardeducation.onlineClass.OnlineClassMain;


import java.io.File;


public class PdfViewActivity extends AppCompatActivity {

    String url;
    private PDFView pdfView;
    //private SpinKitView spinKitView;
    SpinKitView SpinkitterLoader ; // spinkkit_loading.xml
    private TextView textdelaypdf , openpdfin , browserOK , helptextview;
    private EditText browserCode;
    private LottieAnimationView passlottie;
//    private TemplateView my_template;
    User user;
    private InterstitialAd mInterstitialAd;

    private MaterialCardView  appdisplay, browserdisplay , noresultdisplay;
//    RewardedAd mRewardedAd ;
     private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_pdf_view);
        textdelaypdf = findViewById(R.id.textdelaypdf);
        //spinKitView = findViewById(R.id.spin_kitimp);
        passlottie = findViewById(R.id.passlottie);
        appdisplay = findViewById(R.id.appdisplay);
        browserdisplay = findViewById(R.id.browserdisplay);
        openpdfin = findViewById(R.id.openpdfin);
        noresultdisplay = findViewById(R.id.noresultdisplay);
        browserOK = findViewById(R.id.browserOk);
        helptextview = findViewById(R.id.helptextview);
        browserCode = findViewById(R.id.browserCode);
//        my_template = findViewById(R.id.my_template);
        //spinKitView.setVisibility(View.GONE);
        textdelaypdf.setVisibility(View.GONE);

     //    intersticial ad

        MobileAds.initialize(PdfViewActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();


        InterstitialAd.load(this,"ca-app-pub-8065643524026387/4918698617", adRequest,   // test unit id ca-app-pub-3940256099942544/1033173712
                new InterstitialAdLoadCallback() {                                                     // real ca-app-pub-8065643524026387/4918698617
                    @Override                                                                           // intersticial ca-app-pub-8065643524026387/4918698617
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

//     MediationTestSuite.launch(PdfViewActivity.this);

        url = getIntent().getStringExtra("pdfUrl");
        pdfView =findViewById(R.id.pdfView);

        browserOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog dialog;

                FirebaseFirestore database = FirebaseFirestore.getInstance();
                dialog = new ProgressDialog(PdfViewActivity.this);
                dialog.setMessage("Loading...");
                dialog.show();

                database.collection("Faq").document("browsercode").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        user = documentSnapshot.toObject(User.class);
                        String bcr = user.getSubject();
                        passlottie.setAnimation(R.raw.passwordlottie);
                        passlottie.playAnimation();
                        helptextview.setText("Get Browser Code");
                        helptextview.setTextSize(12);
                        dialog.dismiss();

                        if (browserCode.getText().toString().equals(bcr)){
                            gotoUrl(url  + BuildConfig.APPLICATION_ID);
                        } else if (browserCode.getText().toString().isEmpty()){
                            Toast.makeText(PdfViewActivity.this, "Enter Browser Code", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PdfViewActivity.this, "Wrong Browser Code", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        noresultdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( PdfViewActivity.this , FaqActivity.class);
                startActivity(intent);
            }
        });

        View view = LayoutInflater.from(PdfViewActivity.this).inflate(R.layout.spinkit_loading,null);
         alertDialog = new AlertDialog.Builder(PdfViewActivity.this).setView(view)
                .setCancelable(false)
                .create();
         SpinkitterLoader = view.findViewById(R.id.spin_kit_Loadig);

        appdisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//
//

                alertDialog.show();
                SpinkitterLoader.setVisibility(View.VISIBLE);
                   textdelaypdf.setVisibility(View.VISIBLE);
                   openpdfin.setVisibility(View.GONE);
                   loadFile(url);
            }
        });
                                                               // test native ca-app-pub-3940256099942544/2247696110
        MobileAds.initialize(this);                    // native mpbe ca-app-pub-8065643524026387/5121051230
//        AdLoader adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110")
//                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//                    @Override
//                    public void onNativeAdLoaded(NativeAd nativeAd) {
//                        NativeTemplateStyle styles = new
//                                NativeTemplateStyle.Builder().build();
//                        TemplateView template = findViewById(R.id.my_template);
//                        template.setStyles(styles);
//                        template.setNativeAd(nativeAd);
//                    }
//                })
//                .build();

   //     adLoader.loadAd(new AdRequest.Builder().build());
 }



    private void loadFile(String url) {

        appdisplay.setVisibility(View.GONE);
        openpdfin.setVisibility(View.GONE);
        browserdisplay.setVisibility(View.GONE);
        noresultdisplay.setVisibility(View.GONE);
    //    my_template.setVisibility(View.GONE);
       FileLoader.with(this)
                .load(url)
                .fromDirectory("test4", FileLoader.DIR_INTERNAL)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {
                        File loadedFile = response.getBody();
                        pdfView.fromFile(loadedFile)
                                .defaultPage(0)
                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .spacing(5)
                                .load();
//                        spinKitView.setVisibility(View.GONE);
                        SpinkitterLoader.setVisibility(View.GONE);
                        alertDialog.dismiss();
                        textdelaypdf.setVisibility(View.GONE);

                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        Toast.makeText(PdfViewActivity.this, "Error"+ t.getMessage(), Toast.LENGTH_SHORT).show();
                       // spinKitView.setVisibility(View.GONE);
                        SpinkitterLoader.setVisibility(View.GONE);
                        alertDialog.dismiss();
                        textdelaypdf.setVisibility(View.GONE);
                        appdisplay.setVisibility(View.GONE);
                        openpdfin.setVisibility(View.GONE);
                        browserdisplay.setVisibility(View.GONE);
                        noresultdisplay.setVisibility(View.GONE);
                    }
                });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        if (mInterstitialAd != null) {
            mInterstitialAd.show(PdfViewActivity.this);
        }
            super.onBackPressed();

    }
}