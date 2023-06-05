package com.rohitparmar.mpboardeducation.onlineClass.FaqAnswers;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.R;

import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;

public class faqAnswer2 extends AppCompatActivity {

    private MaterialCardView faqsection;
    private TextView txtFaqAnsewers;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_answer2);
        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        faqsection = findViewById(R.id.faqsection2);
        txtFaqAnsewers = findViewById(R.id.txtFaqAnsewers2);


        ProgressDialog dialog;

        FirebaseFirestore database = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        database.collection("Faq").document("a2").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
                txtFaqAnsewers.setText(String.valueOf(user.getSubject()));
                dialog.dismiss();
            }
        });

        database.collection("Faq").document("a2").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                user = documentSnapshot.toObject(User.class);
                faqsection.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gotoUrl(String.valueOf(user.getFee()) + BuildConfig.APPLICATION_ID);
                    }
                });
                dialog.dismiss();
            }
        });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
