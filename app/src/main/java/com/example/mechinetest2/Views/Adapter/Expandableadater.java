package com.example.mechinetest2.Views.Adapter;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ExpandableListAdapter;


import com.example.mechinetest2.Network.Model.Categories;
import com.example.mechinetest2.Network.Model.Products;
import com.example.mechinetest2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expandableadater implements ExpandableListAdapter {

    private Context context;
    private List<Categories> brands = new ArrayList<Categories>();

    public Expandableadater(Context context, List<Categories> brands) {
        this.context = context;
        this.brands = brands;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return brands.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return brands.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return brands.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ParentHolder parentHolder = null;

        Categories brand = (Categories) getGroup(groupPosition);

        if(convertView == null) {
            LayoutInflater userInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = userInflater.inflate(R.layout.expandablelist_group, null);
            convertView.setHorizontalScrollBarEnabled(true);
            parentHolder = new ParentHolder();
            convertView.setTag(parentHolder);

        } else {
            parentHolder = (ParentHolder) convertView.getTag();
        }

        parentHolder.brandName = (TextView) convertView.findViewById(R.id.tv_headder);
        parentHolder.brandName.setText(brand.getTitle());

        parentHolder.indicator = (ImageView) convertView.findViewById(R.id.image_indicator);

        if(isExpanded) {
            parentHolder.indicator.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
        } else {
            parentHolder.indicator.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ChildHolder childHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.view, parent, false);
            childHolder = new ChildHolder();
            convertView.setTag(childHolder);
        }
        else {
            childHolder = (ChildHolder) convertView.getTag();
        }

        childHolder.horizontalListView = (RecyclerView) convertView.findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2,GridLayoutManager.HORIZONTAL,false);
        childHolder.horizontalListView.setLayoutManager(layoutManager);

        GridAdapter horizontalListAdapter = new GridAdapter(context, brands.get(groupPosition).getProducts());
        childHolder.horizontalListView.setAdapter(horizontalListAdapter);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    private static class ChildHolder {
        static RecyclerView horizontalListView;
    }

    private static class ParentHolder {
        TextView brandName;
        ImageView indicator;
    }

}
