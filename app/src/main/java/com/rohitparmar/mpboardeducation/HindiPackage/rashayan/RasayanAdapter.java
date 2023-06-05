package com.rohitparmar.mpboardeducation.HindiPackage.rashayan;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp.PdfViewActivity;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;

import java.util.List;

class RasayanAdapter extends RecyclerView.Adapter<RasayanAdapter.RasayanviewHolder> {

    private Context context;
    private List<impBookDataModels> list;

    public RasayanAdapter(Context context, List<impBookDataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RasayanviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.impbook_item_layout, parent,false);
        return new RasayanviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RasayanviewHolder holder, int position) {

        holder.bioName.setText(list.get(position).getPdfTitle());

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



    public class RasayanviewHolder extends RecyclerView.ViewHolder {
        private TextView bioName ;
        public RasayanviewHolder(@NonNull View itemView) {
            super(itemView);

            bioName = itemView.findViewById(R.id.impebookName);

        }
    }
}

