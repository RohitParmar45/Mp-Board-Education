package com.rohitparmar.mpboardeducation.scienceClass.Biology;

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

public class bioAdapter extends RecyclerView.Adapter<bioAdapter.bioviewHolder> {

    private Context context;
    private List<impBookDataModels> list;

    public bioAdapter(Context context, List<impBookDataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public bioviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.impbook_item_layout, parent,false);
        return new bioviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull bioviewHolder holder, int position) {

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

    public class bioviewHolder extends RecyclerView.ViewHolder {
        private TextView bioName ;

        public bioviewHolder(@NonNull View itemView) {
            super(itemView);
            bioName = itemView.findViewById(R.id.impebookName);

        }
    }
}
