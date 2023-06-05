package com.rohitparmar.mpboardeducation.scienceClass.scienceui.notes;

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

public class notesBookAdapter extends RecyclerView.Adapter<notesBookAdapter.notesBookViewHolder> {

    private Context context;
    private List<impBookDataModels> list;
   private Activity activity;
    private  RewardedAd mRewardedAd;


    public  notesBookAdapter(Context context, List<impBookDataModels> list,  Activity activity) {
        this.context = context;
        this.list = list;
        this.activity = activity;
    }


    @NonNull
    @Override
    public notesBookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notes_item_layout, parent,false);
        return new notesBookViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull notesBookViewHolder holder, int position) {

        holder.notesBookName.setText(list.get(position).getPdfTitle());

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

    public class notesBookViewHolder extends RecyclerView.ViewHolder {
        private TextView notesBookName ;
        public notesBookViewHolder(@NonNull View itemView) {
            super(itemView);
            notesBookName = itemView.findViewById(R.id.NotesTitle);
        }
    }
}
