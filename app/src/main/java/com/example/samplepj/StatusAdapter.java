package com.example.samplepj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {

    @NonNull
    @Override
    public StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_status_view,parent,false);

        return new StatusViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class StatusViewHolder extends RecyclerView.ViewHolder {
        TextView tvStatus,tvName;
        public StatusViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }
    }
}
