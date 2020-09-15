package com.example.mechinetest2.Network.Model;

import java.util.List;

public class Categories
{
    private String title;

    private List<Products> products;

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public List<Products> getProducts ()
    {
        return products;
    }

    public void setProducts (List<Products> products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [title = "+title+", products = "+products+"]";
    }
}
