package com.rohitparmar.mpboardeducation.scienceClass.EnglishSpec;

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

public class EngSpecAdapter extends RecyclerView.Adapter<EngSpecAdapter.EngSpecviewHolder> {

    private Context context;
    private List<impBookDataModels> list;

    public EngSpecAdapter(Context context, List<impBookDataModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public EngSpecviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.impbook_item_layout, parent,false);
        return new EngSpecviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull EngSpecviewHolder holder, int position) {

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

    public class EngSpecviewHolder extends RecyclerView.ViewHolder {

        private TextView bioName ;

        public EngSpecviewHolder(@NonNull View itemView) {
            super(itemView);
            bioName = itemView.findViewById(R.id.impebookName);

        }
    }

}
