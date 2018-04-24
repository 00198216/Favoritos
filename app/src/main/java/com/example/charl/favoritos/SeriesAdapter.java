package com.example.charl.favoritos;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder> {
    private ArrayList<Series> series;

    public static class SeriesViewHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView name;
        ImageView img;
        Button button;
        Context cxt;

        public SeriesViewHolder(View itemView){
            super(itemView);
            cxt=itemView.getContext();
            card=itemView.findViewById(R.id.card_view);
            name=itemView.findViewById(R.id.name);
            img=itemView.findViewById(R.id.img);
            button=itemView.findViewById(R.id.boton);


        }

    }

    public SeriesAdapter(ArrayList<Series> series) {
        this.series = series;
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int ViewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview,parent,false);
        return (new SeriesViewHolder(v));
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, final int position){
        holder.name.setText(series.get(position).getName());
        holder.img.setImageResource(series.get(position).getImg());
        holder.button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(view.getContext(),"Descripcion:"+series.get(position).getDesc(), Toast.LENGTH_LONG).show();
            }
        });
    }



    @Override
    public int getItemCount(){
        return series.size();
    }
}
