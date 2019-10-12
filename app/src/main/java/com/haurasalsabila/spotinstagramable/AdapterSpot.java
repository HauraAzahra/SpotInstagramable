package com.haurasalsabila.spotinstagramable;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterSpot  extends RecyclerView.Adapter<AdapterSpot.ViewHolder>  {

    Context context;
    String[] nameSpot,descriptionSpot,placeSpot;
    int[] photoSpot;

    public AdapterSpot(Context context, String[] nameSpot, String[] descriptionSpot,String [] placeSpot, int[] photoSpot) {
        this.context = context;
        this.nameSpot = nameSpot;
        this.descriptionSpot = descriptionSpot;
        this.placeSpot = placeSpot;

        this.photoSpot = photoSpot;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_spot,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvName.setText(nameSpot[i]);
        viewHolder.tvDescription.setText(descriptionSpot[i]);
        viewHolder.tvPlace.setText(placeSpot[i]);

        Glide.with(context).load(photoSpot[i]).into(viewHolder.imgSpot);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailSpot.class);
                intent.putExtra("name_spot", nameSpot[i]);
                intent.putExtra("description_spot",descriptionSpot[i]);
                intent.putExtra("place_spot",placeSpot[i]);
                intent.putExtra("photo_spot",photoSpot[i]);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return photoSpot.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvDescription,tvPlace;
        ImageView imgSpot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvPlace = itemView.findViewById(R.id.tv_item_place);
            imgSpot = itemView.findViewById(R.id.img_item_photo);
        }
    }
}


