package com.rohitparmar.mpboardeducation.onlineClass.faculty;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rohitparmar.mpboardeducation.R;
import com.rohitparmar.mpboardeducation.model.TeacherDataModels;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<TeacherDataModels> list;
    private Context context;
    private String category;


    public TeacherAdapter(List<TeacherDataModels> list, Context context) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);
        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {
        TeacherDataModels item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText( "Zoom Meeting Link");
        holder.post.setText(item.getPost());

        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(item.getEmail()); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                context.startActivity(intent);
            }
        });



        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.profileavatar).into(holder.imageView);

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Mr. " + item.getName(), Toast.LENGTH_SHORT).show();
                    Uri uri = Uri.parse(item.getInstagram()); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    context.startActivity(intent);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;

        private ImageView imageView;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.TeacherNameLay);
            email = itemView.findViewById(R.id.TeacheremailLay);
            post = itemView.findViewById(R.id.TeacherPostLay);
            imageView = itemView.findViewById(R.id.teacherImageLay);

        }
    }



}

