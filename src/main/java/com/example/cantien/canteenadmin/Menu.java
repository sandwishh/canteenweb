package com.example.cantien.canteenadmin;

public class Menu {
    protected int id;
    protected String dname;
    protected String price;
    protected String category;
    protected String photo;


    public Menu() {
    }

    public Menu(String dname, String price, String category,String photo) {
        this.dname = dname;
        this.price = price;
        this.category = category;
        this.photo=photo;
    }

    public Menu(int id, String dname, String price, String category,String photo) {
        this.id = id;
        this.dname = dname;
        this.price = price;
        this.category = category;
        this.photo=photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

