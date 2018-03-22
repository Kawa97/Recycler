package com.example.corsista.recycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by corsista on 19/03/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private String[] dataSet;

    public RecyclerAdapter(String[] dataSet) {
        this.dataSet = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        private TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout linearLayout;
        if(Singleton.getInstance().getActiveManager().equals("linearLayout")){
        linearLayout= (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);}
        else{
        linearLayout= (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_grid,parent,false);}
        ViewHolder viewHolder= new ViewHolder(linearLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    ImageView imageView = holder.itemView.findViewById(R.id.imageView);
    imageView.setImageResource(R.drawable.ic_launcher_foreground);
    TextView textView = holder.itemView.findViewById(R.id.textView);
    textView.setText(dataSet[position]);
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }


}
