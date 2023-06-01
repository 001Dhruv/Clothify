package com.example.clothify;

public class bill_fragment_model {

    ////////NEED TO CHANGE IMG TYPE TO STRING FOR ACCESING THE ITEMS FROM SERVER
    String img;
    String name;
    String desc;
    String price;
    String type;
    String gender;
    int p_id;
    String sr_no;
    String qty;
    bill_fragment_model(String img, String name, String desc, String price, String type, String gender, int p_id,String sr_no,String qty){
        this.desc=desc;
        this.img=img;
        this.name=name;
        this.price=price;
        this.desc=desc;
        this.type=type;
        this.gender=gender;
        this.p_id=p_id;
        this.qty=qty;
        this.sr_no=sr_no;
    }
}
