package com.rohitparmar.mpboardeducation.tenthclass.MathsX;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.ArrayList;
import java.util.List;

public class MathsXPrevious extends AppCompatActivity {


    private RecyclerView notesbookRecycler;

    private DatabaseReference reference;
    private List<impBookDataModels> list;
    private MathsXAdapter adapters;
    private SpinKitView spinKitView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_x_previous);

        spinKitView = findViewById(R.id.spin_kitMathsX);
        spinKitView.setVisibility(View.VISIBLE);


        notesbookRecycler = findViewById(R.id.MathsXRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("MathsXpdf");
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

                adapters = new MathsXAdapter(MathsXPrevious.this, list);
                notesbookRecycler.setLayoutManager(new LinearLayoutManager(MathsXPrevious.this));
                notesbookRecycler.setAdapter(adapters);
                spinKitView.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MathsXPrevious.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                spinKitView.setVisibility(View.GONE);
            }
        });

    }

}