package com.example.piratilgame;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class cafeSearch_Adapter extends RecyclerView.Adapter<cafeSearch_Adapter.viewHolder> {

    Context context;
    ArrayList<cafeSearch_Model> searchModels;

    public cafeSearch_Adapter(Context context, ArrayList<cafeSearch_Model> searchModels) {
        this.context = context;
        this.searchModels = searchModels;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater=LayoutInflater.from(context);
        View view =layoutInflater.inflate(R.layout.cafe_address_item, null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int i) {
        holder.gemcount.setText(searchModels.get(i).getGemCount());
        holder.cafename.setText(searchModels.get(i).getCafeName());
        holder.cafeaddress.setText(searchModels.get(i).getCafeAddress());



    }

    @Override
    public int getItemCount() {
        return searchModels.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView gemcount, cafeaddress, cafename;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            gemcount=itemView.findViewById(R.id.gemCount);
            cafename=itemView.findViewById(R.id.cafeName);
            cafeaddress=itemView.findViewById(R.id.cafeAddress);

        }
    }
}
