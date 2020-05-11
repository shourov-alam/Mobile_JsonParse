package com.shourov.mobile_jsonparse;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {

    ArrayList<Pojo> list;
    Context context;

    public DataAdapter() {

    }

    public DataAdapter(ArrayList<Pojo> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {



        return new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.row_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {

        Pojo currentList = list.get(position);


        // Picasso.get().load(currentList.getUrl()).into(holder.imageView);

        Picasso.get()
                .load(currentList.getUrl())
                .resize(550, 600)
                .centerCrop()
                .into(holder.imageView);


        holder.company_name.setText("Company: "+currentList.getCompanyName());

        holder.name.setText("Name: "+currentList.getName());
        holder.ram.setText("Ram: "+currentList.getRam());
        holder.rom.setText("Rom: "+currentList.getRom());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}