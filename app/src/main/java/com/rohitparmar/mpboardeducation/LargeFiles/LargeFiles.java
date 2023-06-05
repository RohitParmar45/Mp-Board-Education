package com.rohitparmar.mpboardeducation.LargeFiles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;
import com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp.PdfViewActivity;

import java.util.ArrayList;
import java.util.List;

public class LargeFiles extends AppCompatActivity {

    private RecyclerView notesbookRecycler;
    private DatabaseReference reference;
    private List<impBookDataModels> list;
    private LargeFileAdapter adapters;
    private SpinKitView spinKitView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_files);
        spinKitView = findViewById(R.id.spin_kitLargeFile);
        spinKitView.setVisibility(View.VISIBLE);


        notesbookRecycler = findViewById(R.id.largeFileRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("LargeFilesPdf");
        getData();


    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {

                list = new ArrayList<>();
                for (DataSnapshot snapshot : datasnapshot.getChildren()){
                    impBookDataModels data = snapshot.getValue(impBookDataModels.class);
                    list.add(data);
                }

                adapters = new LargeFileAdapter(LargeFiles.this, list);
                notesbookRecycler.setLayoutManager(new LinearLayoutManager(LargeFiles.this));
                notesbookRecycler.setAdapter(adapters);
                spinKitView.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LargeFiles.this, error.getMessage(), Toast.LENGTH_LONG).show();
                spinKitView.setVisibility(View.GONE);
            }
        });
    }



}