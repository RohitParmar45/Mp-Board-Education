package com.rohitparmar.mpboardeducation.onlineClass;

//import static com.rohitparmar.mpboardeducation.MainActivity.myClass;
//import static com.rohitparmar.mpboardeducation.MainActivity.noteFirebase;
//import static com.rohitparmar.mpboardeducation.MainActivity.subjectFirebase;
//import static com.rohitparmar.mpboardeducation.MainActivity.subjectTimingFirebase;
//import static com.rohitparmar.mpboardeducation.MainActivity.zoomLink;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.Premium.LoginPage.SignIn;
import com.rohitparmar.mpboardeducation.Premium.LoginPage.regDone;
import com.rohitparmar.mpboardeducation.Premium.YtIndexing.PaidCourses;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.TeacherDataModels;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.onlineClass.faculty.facultyFragment;

import java.util.List;
import java.util.Objects;

//import org.w3c.dom.Text;


public class OnlineClassMain extends AppCompatActivity {
    private MaterialCardView RegOnline , InstaOnline , TelegramOnline , ZoomOnline ,faqsection , whatsappSection ;
    private LottieAnimationView animationView;
    private TextView zoomlink , helptextview;
    private View viewonline;
    FirebaseFirestore database = FirebaseFirestore.getInstance();
    FirebaseFirestore db;
    User user;
    public static List<String> valList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_class_main);
        RegOnline = findViewById(R.id.RegOnline);
        InstaOnline = findViewById(R.id.InstaOnline);
        TelegramOnline = findViewById(R.id.TelegramOnline);
        ZoomOnline = findViewById(R.id.zoomOnline);
        animationView = findViewById(R.id.splashAnimation);
        faqsection = findViewById(R.id.faqsection);
        zoomlink = findViewById(R.id.zoomlink);
        viewonline = findViewById(R.id.viewonline);
        whatsappSection = findViewById(R.id.whatsappSection);

        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        faqsection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OnlineClassMain.this , FaqActivity.class);
                startActivity(intent);
            }
        });

        ZoomOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(OnlineClassMain.this, facultyFragment.class);
                startActivity(intent);

            }
        });

        InstaOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/mpbe.app/?utm_medium=copy_link"  + BuildConfig.APPLICATION_ID);
            }
        });

        TelegramOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View view = LayoutInflater.from(OnlineClassMain.this).inflate(R.layout.zoom_notif_dialog,null);
                AlertDialog alertDialog = new AlertDialog.Builder(OnlineClassMain.this).setView(view)
                        .setCancelable(false)
                        .create();
                alertDialog.show();

                Button okbtnzoom = view.findViewById(R.id.okbtnzoom);
                Button whatsappbtnzoom = view.findViewById(R.id.whatsappbtnzoom);
                alertDialog.getWindow().setBackgroundDrawableResource(android.R.color.white);
                okbtnzoom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                whatsappbtnzoom.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });


//               Intent intent = new Intent(OnlineClassMain.this , InitAuthSDKActivity.class);
//               intent.putExtra("keyMyClass", myClass);
//               intent.putExtra("keyZoomLink", zoomLink);
//               intent.putExtra("keysubjectFirebase", subjectFirebase);
//               intent.putExtra("keysubjectTimingFirebase", subjectTimingFirebase);
//               intent.putExtra("keynoteFirebase", noteFirebase);
//               startActivity(intent);
            }
        });

        zoomlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://play.google.com/store/apps/details?id=us.zoom.videomeetings"  + BuildConfig.APPLICATION_ID);
            }
        });

        whatsappSection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String wpurl = "https://wa.me/+919407000651?text= *Hello Sir*";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(wpurl));
                startActivity(intent);
            }
        });


        SharedPreferences shrd = getSharedPreferences("isFirstTime" , MODE_PRIVATE);
        Boolean isFirstTime = shrd.getBoolean("isFirstTime", true);

        SharedPreferences shrdCreditial = getSharedPreferences("credential" , MODE_PRIVATE);
        String localMob = shrdCreditial.getString("mobileNo", "1234567890");



        if (isFirstTime) {
            FirebaseFirestore database = FirebaseFirestore.getInstance();
            database.collection("linkingFirstore").document("dialogboxmain").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    User user = documentSnapshot.toObject(User.class);
                    String boolean_firebase_val = String.valueOf(user.getFee());
                    String Header = String.valueOf(user.getRegistration());
                    String TextDescrip = String.valueOf(user.getSubject());

                    if (!boolean_firebase_val.isEmpty()){

                        View view = LayoutInflater.from(OnlineClassMain.this).inflate(R.layout.main_dialog_firebase,null);
                        AlertDialog alertDialog = new AlertDialog.Builder(OnlineClassMain.this).setView(view)
                                .setCancelable(false)
                                .create();
                        alertDialog.show();

                        TextView header1 = view.findViewById(R.id.Heading_Dialog_firebase);
                        TextView TextDescrip1 = view.findViewById(R.id.dialoginfo_text);
                        Button okFire = view.findViewById(R.id.okBtnDialogFirebase);
                        header1.setText(Header);
                        TextDescrip1.setText(TextDescrip);

                        okFire.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                alertDialog.dismiss();
                            }
                        });
                    }

                }
            });
        }


        db = FirebaseFirestore.getInstance();

        RegOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent( OnlineClassMain.this, facultyFragment.class ) ;
//                startActivity(intent);
                viewonline.setVisibility(View.GONE);
                // Toast.makeText(OnlineClassMain.this, localMob + " " + isFirstTime, Toast.LENGTH_SHORT).show();

                DocumentReference ss=  database.collection("PremiumStudents").document(localMob);

                database.collection("PremiumStudents").document(ss.getId()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        user = documentSnapshot.toObject(User.class);

                        valList =user.getVal();

                        List<String> ss =user.getVal();


                        if (!isFirstTime ){

                            if (Objects.equals(valList.get(0), "0")){
                                startActivity(new Intent(OnlineClassMain.this, regDone.class));
                            }else
                                startActivity(new Intent(OnlineClassMain.this, PaidCourses.class));
//                          Toast.makeText(Login.this, "valList "+valList.get(0), Toast.LENGTH_SHORT).show();
                        }

                        if (isFirstTime) {
                            //show start activity
                            startActivity(new Intent(OnlineClassMain.this, SignIn.class));
//                          Toast.makeText(Login.this, "First Run", Toast.LENGTH_LONG)
//                                  .show();
                        }

                    }
                });
            }
        });


    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}