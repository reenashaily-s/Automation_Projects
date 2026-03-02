package com.PojoClass;

public class PostPojoData 
{
    public int year;
    public double price;
    public String CPUmodel;
    public String Harddisksize;

    public PostPojoData(int year, double price, String CPUmodel, String Harddisksize) {
        this.year = year;
        this.price = price;
        this.CPUmodel = CPUmodel;
        this.Harddisksize = Harddisksize;
    }

    public PostPojoData() {}
}