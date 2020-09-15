package com.example.mechinetest2.Network.Model;

import java.io.Serializable;

public class Products implements Serializable
{
    private String price;

    private String imageUrl;

    private String description;

    private String title;

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getImageUrl ()
    {
        return imageUrl;
    }

    public void setImageUrl (String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [price = "+price+", imageUrl = "+imageUrl+", description = "+description+", title = "+title+"]";
    }
}

