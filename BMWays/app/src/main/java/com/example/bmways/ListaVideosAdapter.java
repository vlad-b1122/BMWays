package com.example.bmways;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaVideosAdapter extends RecyclerView.Adapter<ListaVideosAdapter.MyViewHolder> {

    ArrayList<String> data1, data2;
    int images[];
    Context context;

    public ListaVideosAdapter(Context ct, ArrayList<String> s1, ArrayList<String> s2, int img[]){
        this.context = ct;
        this.data1 = s1;
        this.data2 = s2;
        this.images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.lista_videos_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tituloVideo.setText(data1.get(position));
        holder.descripcionVideo.setText(data2.get(position));
        holder.thumbnailVideo.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return data1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tituloVideo, descripcionVideo;
        ImageView thumbnailVideo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloVideo = itemView.findViewById(R.id.tituloVideoRow);
            descripcionVideo = itemView.findViewById(R.id.descripcionVideoRow);
            thumbnailVideo = itemView.findViewById(R.id.thumbnailVideoRow);
        }
    }


}
