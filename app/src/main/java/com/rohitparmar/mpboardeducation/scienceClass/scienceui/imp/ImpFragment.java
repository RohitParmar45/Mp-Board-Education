package com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.ArrayList;
import java.util.List;

public class ImpFragment extends Fragment {

private RecyclerView impbookRecycler;

    private DatabaseReference reference;
    private List<impBookDataModels> list;
    private impBookAdapter adapters;

    private SpinKitView spinKitView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_imp, container, false);

        spinKitView = view.findViewById(R.id.spin_kit);
        spinKitView.setVisibility(View.VISIBLE);


        impbookRecycler = view.findViewById(R.id.impbookRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Importantpdf");
        getData();
        
        return view;
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

                adapters = new impBookAdapter(getContext(), list, getActivity());
                impbookRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                impbookRecycler.setAdapter(adapters);
                spinKitView.setVisibility(View.GONE);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                spinKitView.setVisibility(View.GONE);
            }
        });

    }
}