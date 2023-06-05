package com.rohitparmar.mpboardeducation.commerceActivity.commerceui.notesCom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp.PdfViewActivity;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.List;

public class notesComAdapter extends RecyclerView.Adapter<notesComAdapter.notesComviewHolder> {

    private Context context;
    private List<impBookDataModels> list;
    private Activity activity;
    private RewardedAd mRewardedAd;


    public notesComAdapter(Context context, List<impBookDataModels> list, Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public notesComviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_item_layout, parent,false);
        return new notesComviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull notesComviewHolder holder, int position) {


        holder.impbookName.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context, PdfViewActivity.class);
                intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class notesComviewHolder extends RecyclerView.ViewHolder {
        private TextView impbookName ;
        public notesComviewHolder(@NonNull View itemView) {
            super(itemView);
            impbookName = itemView.findViewById(R.id.NotesTitle);


        }
    }

}
