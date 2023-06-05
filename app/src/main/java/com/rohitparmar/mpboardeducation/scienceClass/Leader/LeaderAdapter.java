package com.rohitparmar.mpboardeducation.scienceClass.Leader;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.User;
import com.rohitparmar.mpboardeducation.model.impBookDataModels;
import com.rohitparmar.mpboardeducation.scienceClass.scienceui.imp.PdfViewActivity;

import java.util.ArrayList;
import java.util.List;

public class LeaderAdapter extends RecyclerView.Adapter<LeaderAdapter.LeaderviewHolder> {


    private Context context;
    private List<User> list;

    public LeaderAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LeaderviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.raw_leader, parent,false);
        return new LeaderviewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LeaderviewHolder holder, int position) {

        User user = list.get(position);

        holder.name.setText(user.getSubject());
        holder.marks.setText(user.getFee());

        holder.index.setText(String.format("#%d", position+1));

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LeaderviewHolder extends RecyclerView.ViewHolder {

        private TextView name , marks , index ;
        public LeaderviewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            marks = itemView.findViewById(R.id.marks);
            index = itemView.findViewById(R.id.index);

        }
    }
}
