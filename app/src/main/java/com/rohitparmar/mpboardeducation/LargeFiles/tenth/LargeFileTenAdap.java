package com.rohitparmar.mpboardeducation.LargeFiles.tenth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.List;

class LargeFileTenAdap extends RecyclerView.Adapter<LargeFileTenAdap.LargeFileTenViewHolder> {
    private InterstitialAd mInterstitialAd;
    private Context context;
    private List<impBookDataModels> list;

    public LargeFileTenAdap(Context context, List<impBookDataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LargeFileTenAdap.LargeFileTenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.impbook_item_layout, parent,false);

        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(view.getContext(), "ca-app-pub-8065643524026387/4918698617", adRequest,   // test unit id ca-app-pub-3940256099942544/1033173712
                new InterstitialAdLoadCallback() {                                                     // real ca-app-pub-8065643524026387/4918698617
                    @Override                                                                           // intersticial ca-app-pub-8065643524026387/4918698617
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i("TAG", "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i("TAG", loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });
        // test native ca-app-pub-3940256099942544/2247696110
        MobileAds.initialize(view.getContext());


        return new LargeFileTenAdap.LargeFileTenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LargeFileTenAdap.LargeFileTenViewHolder holder, int position) {

        holder.bioName.setText(list.get(position).getPdfTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MobileAds.initialize(v.getContext(), new OnInitializationCompleteListener() {
                    @Override
                    public void onInitializationComplete(InitializationStatus initializationStatus) {
                    }
                });
                if (mInterstitialAd != null) {
                    mInterstitialAd.show((Activity) context);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            Uri uri = Uri.parse(list.get(position).getPdfUrl());
                            context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
                            mInterstitialAd = null;
                        }});
                }else{
                    Uri uri = Uri.parse(list.get(position).getPdfUrl());
                    context.startActivity(new Intent(Intent.ACTION_VIEW, uri));
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class LargeFileTenViewHolder extends RecyclerView.ViewHolder {
        private TextView bioName ;
        public LargeFileTenViewHolder(@NonNull View itemView) {
            super(itemView);
            bioName = itemView.findViewById(R.id.impebookName);
        }

    }
}

