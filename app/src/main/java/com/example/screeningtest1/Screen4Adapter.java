package com.example.screeningtest1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Screen4Adapter extends RecyclerView.Adapter<Screen4Adapter.Screen4Holder> {
    private OnItemClickCallback onItemClickCallback;
    String[] id;
    String[] nama;
    String[] birthdate;
    int[] img;

    public Screen4Adapter(String[] id, String[] nama, String[] birthdate, int[] img) {
        this.id = id;
        this.nama = nama;
        this.birthdate = birthdate;
        this.img = img;
    }

    @NonNull
    @Override
    public Screen4Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_screen4,parent,false);
        return new Screen4Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Screen4Holder holder, int position) {
        holder.imageView.setImageResource(img[position]);
        holder.itemView.setOnClickListener(v ->
                onItemClickCallback.onitemClicked(nama[holder.getAdapterPosition()],birthdate[holder.getAdapterPosition()]));
    }

    @Override
    public int getItemCount() {
        return img.length;
    }

    public class Screen4Holder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public Screen4Holder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgview);
        }
    }
    public interface OnItemClickCallback{
        void onitemClicked(String nama,String tgl_lahir);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
}

