package com.rohitparmar.mpboardeducation.LargeFiles.tenth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohitparmar.mpboardeducation.MainActivity;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.SplashActivity;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.ArrayList;
import java.util.List;

public class LargeFileTen extends AppCompatActivity {

    private RecyclerView notesbookRecycler;
    private DatabaseReference reference;
    private List<impBookDataModels> list;
    private LargeFileTenAdap adapters;
    private SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_large_file_ten);
        spinKitView = findViewById(R.id.spin_kitLargeFileTen);
        spinKitView.setVisibility(View.VISIBLE);


        notesbookRecycler = findViewById(R.id.largeFileTenRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("LargeFilesTenPdf");
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

                adapters = new LargeFileTenAdap(LargeFileTen.this, list);
                notesbookRecycler.setLayoutManager(new LinearLayoutManager(LargeFileTen.this));
                notesbookRecycler.setAdapter(adapters);

                spinKitView.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LargeFileTen.this, error.getMessage(), Toast.LENGTH_LONG).show();
                spinKitView.setVisibility(View.GONE);
            }
        });
    }



}