package com.example.user.earthquake;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHolder> {
    ArrayList<earthquakeDetailList> arrayList;


    public MyAdapter(ArrayList<earthquakeDetailList> arrayList1)
    {
        this.arrayList=arrayList1;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_display,parent,false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
//        holder.city.setText(arrayList.get(position).getName());
//        holder.prov.setText(arrayList.get(position).getEmail());

        holder.Time.setText(arrayList.get(position).getEarthquakeTime());
        holder.Data.setText(arrayList.get(position).getEarthquakeDate());
        holder.Location.setText(arrayList.get(position).getEarthquakeLoc());
        holder.Magnitude.setText(arrayList.get(position).getEarthquakeMag().toString());


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    class  myViewHolder extends RecyclerView.ViewHolder {

        TextView Location,Data,Magnitude,Time;

        public myViewHolder(View itemView) {
            super(itemView);

            Location=(TextView) itemView.findViewById(R.id.location);
            Data=(TextView) itemView.findViewById(R.id.date);
           Magnitude=(TextView) itemView.findViewById(R.id.magnitude);
            Time=(TextView)itemView.findViewById(R.id.time);

        }
    }
}


