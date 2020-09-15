package com.example.mechinetest2.Views.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mechinetest2.Network.Model.Products;
import com.example.mechinetest2.R;
import com.example.mechinetest2.Views.DetailsPage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GridAdapter  extends  RecyclerView.Adapter<GridAdapter.CustomViewHolder > {
    private Context mContext;
    private List<Products> mobiles = new ArrayList<Products>();

    public GridAdapter(Context context, List<Products> mobileValues) {
        mContext = context;
        mobiles = mobileValues;
//        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return isSection(position)?gridLayoutManager.getSpanCount():1;
//            }
//        });
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expandablelist_child, parent, false);

        return new GridAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        final Products data = mobiles.get(position);
        if(data!=null){
            Glide.with(mContext).load(data.getImageUrl()).into(holder.imageView);
            holder.itemname.setText(data.getTitle());
            holder.itemprice.setText('₹' +data.getPrice());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(mContext, DetailsPage.class);
                    i.putExtra("assi", (Serializable) data);

                    mContext.startActivity(i);

                }
            });


        }



    }

    @Override
    public int getItemCount() {
        if(mobiles==null){
            return 0;
        }else {
            return mobiles.size();

        }

    }


    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView itemname,itemprice;
        CardView cardView;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            itemname =(TextView)itemView.findViewById(R.id.textView);
            itemprice =(TextView)itemView.findViewById(R.id.textView1);
            cardView =(CardView)itemView.findViewById(R.id.cardView);

        }
    }
}
