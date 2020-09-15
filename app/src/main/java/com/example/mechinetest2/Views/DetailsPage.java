package com.example.mechinetest2.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mechinetest2.Network.Model.Products;
import com.example.mechinetest2.R;

import java.util.List;

public class DetailsPage extends AppCompatActivity {

    TextView itemname,itemprice,itemdiscre;
    ImageView back,fullimage;
    Products products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);
        itemname =(TextView)findViewById(R.id.itemnames);
        itemprice =(TextView)findViewById(R.id.itemprices);
        itemdiscre =(TextView)findViewById(R.id.itemdiscription);
        back=(ImageView)findViewById(R.id.backs);
        fullimage=(ImageView)findViewById(R.id.detailimage);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            products = (Products) bundle.get("assi");
            itemname.setText(products.getTitle());
            itemprice.setText('₹' +products.getPrice());
            itemdiscre.setText(products.getDescription());
            Glide.with(this).load(products.getImageUrl()).into(fullimage);


        }
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





    }
}