package com.rohitparmar.mpboardeducation.onlineClass.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohitparmar.mpboardeducation.BuildConfig;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.TeacherDataModels;

import java.util.ArrayList;
import java.util.List;

public class facultyFragment extends AppCompatActivity {

    private RecyclerView csDepartment, physicsDepartment , mechanicalDepartment, chemistryDepartment;
    private LinearLayout csNoData, mechNoData, physicsNoData, chemistyNoData;
    private List<TeacherDataModels> list1,list2,list3,list4;
    private TeacherAdapter adapter;
    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_fragment);

        csDepartment = findViewById(R.id.csDepartment);
        physicsDepartment = findViewById(R.id.physicsDepartment);
        mechanicalDepartment = findViewById(R.id.mechanicalDepartment);
        chemistryDepartment = findViewById(R.id.chemistryDepartment);


        csNoData = findViewById(R.id.csNodata);
        mechNoData = findViewById(R.id.mechNodata);
        physicsNoData = findViewById(R.id.physicsNodata);
        chemistyNoData = findViewById(R.id.chemistryNodata);

        reference = FirebaseDatabase.getInstance().getReference().child("Teachers");

        csDepartment();
        mechanicalDepartment();
        physicsDepartment();
        chemistryDepartment();
    }


    private void csDepartment() {
        dbRef = reference.child("computer science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherDataModels data = snapshot1.getValue(TeacherDataModels.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(facultyFragment.this));
                    adapter = new TeacherAdapter(list1,facultyFragment.this);
                    csDepartment.setAdapter(adapter);
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(facultyFragment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    mechNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherDataModels data = snapshot1.getValue(TeacherDataModels.class);
                        list2.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(facultyFragment.this));
                    adapter = new TeacherAdapter(list2,facultyFragment.this);
                    mechanicalDepartment.setAdapter(adapter);
                    mechNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(facultyFragment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void physicsDepartment() {
        dbRef = reference.child("physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }else {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherDataModels data = snapshot1.getValue(TeacherDataModels.class);
                        list3.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(facultyFragment.this));
                    adapter = new TeacherAdapter(list3,facultyFragment.this);
                    physicsDepartment.setAdapter(adapter);
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(facultyFragment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void chemistryDepartment() {
        dbRef = reference.child("chemistry");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    chemistyNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                }else {

                    for (DataSnapshot snapshot1 : snapshot.getChildren()){
                        TeacherDataModels data = snapshot1.getValue(TeacherDataModels.class);
                        list4.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(facultyFragment.this));
                    adapter = new TeacherAdapter(list4,facultyFragment.this);
                    chemistryDepartment.setAdapter(adapter);
                    chemistyNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(facultyFragment.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}