package com.example.clothify;

public class home_fragment_model {

    ////////NEED TO CHANGE IMG TYPE TO STRING FOR ACCESING THE ITEMS FROM SERVER
    String img;
    String name;
    String desc;
    String price;
    String type;
    String gender;
    int p_id;
    home_fragment_model(String img,String name,String desc,String price,String type,String gender,int p_id){
        this.desc=desc;
        this.img=img;
        this.name=name;
        this.price="Price: "+price;
        this.desc=desc;
        this.type="Type: "+type;
        this.gender="Made for: "+gender;
        this.p_id=p_id;
    }
}
