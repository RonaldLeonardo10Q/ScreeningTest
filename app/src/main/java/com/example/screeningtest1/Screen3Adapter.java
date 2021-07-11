package com.example.screeningtest1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Screen3Adapter extends RecyclerView.Adapter<Screen3Adapter.Screen3Holder> {
    private final List<EventModel> eventList;
    private OnItemClickCallback onItemClickCallback;


    public Screen3Adapter(List<EventModel> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public Screen3Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_screen3,parent,false);
        return new Screen3Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Screen3Holder holder, int position) {
        EventModel event = eventList.get(position);
        holder.title.setText(event.getNama());
        holder.date.setText(event.getDate());
        holder.desc.setText(event.getDesc());
        holder.imageView.setImageResource(event.getImage());
        holder.itemView.setOnClickListener(v ->
                onItemClickCallback.onitemClicked(eventList.get(holder.getAdapterPosition())));
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public class Screen3Holder extends RecyclerView.ViewHolder{
        TextView title,date,desc;
        ImageView imageView;
        public Screen3Holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            date = itemView.findViewById(R.id.tv_date);
            desc = itemView.findViewById(R.id.tv_desc);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
    public interface OnItemClickCallback{
        void onitemClicked(EventModel data);
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }
}
