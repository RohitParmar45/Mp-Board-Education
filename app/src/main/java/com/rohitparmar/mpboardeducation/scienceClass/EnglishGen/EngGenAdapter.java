package com.rohitparmar.mpboardeducation.scienceClass.EnglishGen;

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

public class EngGenAdapter extends RecyclerView.Adapter<EngGenAdapter.EngGenviewHolder> {

    private Context context;
    private List<impBookDataModels> list;

    public EngGenAdapter(Context context, List<impBookDataModels> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public EngGenviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.impbook_item_layout, parent,false);
        return new EngGenAdapter.EngGenviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EngGenviewHolder holder, int position) {

        holder.EngGenName.setText(list.get(position).getPdfTitle());

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

    public class EngGenviewHolder extends RecyclerView.ViewHolder {

        private TextView EngGenName ;
        public EngGenviewHolder(@NonNull View itemView) {
            super(itemView);
            EngGenName = itemView.findViewById(R.id.impebookName);

        }
    }

}
