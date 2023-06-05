package com.rohitparmar.mpboardeducation.scienceClass.scienceui.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

public class notesFragment extends Fragment {


    private RecyclerView notesbookRecycler;
    private TextView textdelaynotes;
    private DatabaseReference reference;
    private List<impBookDataModels> list;
    private notesBookAdapter adapters;
    private SpinKitView spinKitView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notes, container, false);
        spinKitView = view.findViewById(R.id.spin_kit);
        textdelaynotes = view.findViewById(R.id.textdelaynotes);
        spinKitView.setVisibility(View.VISIBLE);
        textdelaynotes.setVisibility(View.VISIBLE);

        notesbookRecycler = view.findViewById(R.id.notesBookRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("Notespdf");
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

                adapters = new notesBookAdapter(getContext(), list, getActivity());
                notesbookRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                notesbookRecycler.setAdapter(adapters);

                spinKitView.setVisibility(View.GONE);
                textdelaynotes.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                spinKitView.setVisibility(View.GONE);
                textdelaynotes.setVisibility(View.GONE);
            }
        });

    }
}