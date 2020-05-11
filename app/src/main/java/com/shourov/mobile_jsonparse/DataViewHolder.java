package com.shourov.mobile_jsonparse;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;




public class DataViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView company_name,name,ram,rom;



    public DataViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.image);
        company_name=itemView.findViewById(R.id.companyname);
        name= itemView.findViewById(R.id.name);
        ram=itemView.findViewById(R.id.ram);
        rom=itemView.findViewById(R.id.rom);




    }
}