package com.example.dd.retrofit2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<AndroidVersion> android;
    ItemClicked activity;

    public interface ItemClicked
    {
        void onItemClicked(AndroidVersion androidVersion);
    }

    public DataAdapter(Context context, ArrayList<AndroidVersion> android) {

        this.android = android;
        activity = (ItemClicked) context;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(android.get(position));
        holder.tv_name.setText(android.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;
        private TextView tv_version;
        private TextView tv_api_level;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_version = (TextView)itemView.findViewById(R.id.tv_version);
            tv_api_level = (TextView)itemView.findViewById(R.id.tv_api_level);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    activity.onItemClicked(android.get(getAdapterPosition()));

                }
            });

        }
    }
}