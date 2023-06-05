package com.rohitparmar.mpboardeducation.scienceClass.Leader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;

import java.util.ArrayList;

public class LeaderActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader);
        ProgressDialog dialog;


        FirebaseFirestore database = FirebaseFirestore.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();
       recyclerView = findViewById(R.id.recyclerView11);

        final ArrayList<User> users = new ArrayList<>();
        final LeaderAdapter adapter = new LeaderAdapter(LeaderActivity.this, users);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(LeaderActivity.this));

        database.collection("LeaderBoard").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(DocumentSnapshot snapshot : queryDocumentSnapshots) {
                    dialog.dismiss();
                    User user = snapshot.toObject(User.class);
                    users.add(user);
                }
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });


    }
}