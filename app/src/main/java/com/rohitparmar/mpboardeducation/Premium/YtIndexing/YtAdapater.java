package com.rohitparmar.mpboardeducation.Premium.YtIndexing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.List;


public class YtAdapater extends RecyclerView.Adapter<YtAdapater.YtAdapaterViewHolder> {


    private Context context;
    private List<impBookDataModels> list;

    public YtAdapater(Context context, List<impBookDataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public YtAdapaterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.yt_recycler_view, parent,false);
        return new YtAdapaterViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull YtAdapaterViewHolder holder, int position) {
        holder.bioName.setText(list.get(position).getPdfTitle());
        holder.chapName.setText(list.get(position).getChapName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YtVideoPlayer.class);
                intent.putExtra("pdfUrl",list.get(position).getPdfUrl());
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class YtAdapaterViewHolder extends RecyclerView.ViewHolder {

        private TextView bioName ;
        private TextView chapName ;

        public YtAdapaterViewHolder(@NonNull View itemView) {
            super(itemView);

            bioName = itemView.findViewById(R.id.impebookName);
            chapName = itemView.findViewById(R.id.questionNum);

        }
    }
}


