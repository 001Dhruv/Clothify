package com.example.clothify;

public class home_fragment_model {

    ////////NEED TO CHANGE IMG TYPE TO STRING FOR ACCESING THE ITEMS FROM SERVER
    int img;
    String name;
    String desc;
    String price;
    home_fragment_model(int img,String name,String desc,String price){
        this.desc=desc;
        this.img=img;
        this.name=name;
        this.price=price;
    }
}
