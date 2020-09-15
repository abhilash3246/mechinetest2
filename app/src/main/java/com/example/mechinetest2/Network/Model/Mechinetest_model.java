package com.example.mechinetest2.Network.Model;

import java.util.List;

public class Mechinetest_model
{
    private String msg;

    private List<Categories> categories;

    private String status;

    public String getMsg ()
    {
        return msg;
    }

    public void setMsg (String msg)
    {
        this.msg = msg;
    }

    public List<Categories> getCategories ()
    {
        return categories;
    }

    public void setCategories (List<Categories> categories)
    {
        this.categories = categories;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [msg = "+msg+", categories = "+categories+", status = "+status+"]";
    }
}
