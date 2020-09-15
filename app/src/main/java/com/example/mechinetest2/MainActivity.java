package com.example.mechinetest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ProgressBar;

import com.example.mechinetest2.Network.Model.Categories;
import com.example.mechinetest2.Network.Model.Mechinetest_model;
import com.example.mechinetest2.Network.Model.Products;
import com.example.mechinetest2.Utils.Myfunction;
import com.example.mechinetest2.Views.Adapter.Expandableadater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView mExpandablelistView;
    private Expandableadater expandableadater;
    private List<String> listDataHeader;
    private HashMap<String, List<Products>> listDataChild;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mExpandablelistView = (ExpandableListView) findViewById(R.id.expandablelistview);
        progressBar =(ProgressBar)findViewById(R.id.progressbar);



        if(Myfunction.isNetworkAvailable(MainActivity.this)){
            LoadData();
        }



    }

    private void LoadData() {
        progressBar.setVisibility(View.VISIBLE);
        Call<Mechinetest_model> call = Myfunction.ApisWithConverter().getResult();
        call.enqueue(new Callback<Mechinetest_model>() {
            @Override
            public void onResponse(Call<Mechinetest_model> call, Response<Mechinetest_model> response) {
                Mechinetest_model resp =response.body();
                if(resp!=null){
                    progressBar.setVisibility(View.GONE);
                    List<Categories> categories = new ArrayList<>();
                    categories = resp.getCategories();
                    expandableadater = new Expandableadater(MainActivity.this,categories);
                    mExpandablelistView.setAdapter(expandableadater);
                    mExpandablelistView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
                        int previousGroup = -1;
                        @Override
                        public void onGroupExpand(int groupPosition) {
                            if ((previousGroup != -1) && (groupPosition != previousGroup)) {
                                mExpandablelistView.collapseGroup(previousGroup);
                            }
                            previousGroup = groupPosition;
                        }
                    });


//                    listDataHeader = new ArrayList<String>();
//                    listDataChild = new HashMap<String, List<Products>>();
//                    for(int i =0; i<resp.getCategories().size();i++){
//                        listDataHeader.add(resp.getCategories().get(i).getTitle());
//                        listDataChild.put(resp.getCategories().get(i).getTitle(),resp.getCategories().get(i).getProducts());
//                    }
//
//                    mExpandableListAdapter = new ExpandableListAdapter(MainActivity.this,
//                            listDataHeader, listDataChild,MainActivity.this);
//
//                    // setting list adapter
////                    mExpandablelistView.setAdapter(mExpandableListAdapter);
//
//                    mExpandablelistView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//                        @Override
//                        public boolean onGroupClick(ExpandableListView parent, View v,
//                                                    int groupPosition, long id) {
//                            return false; // This way the expander cannot be collapsed
//                        }
//                    });



                }





            }

            @Override
            public void onFailure(Call<Mechinetest_model> call, Throwable t) {

            }
        });



    }

}

