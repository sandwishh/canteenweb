package com.example.cantien.canteenadmin;

public class MenuDtls {
    private int dishId;
    private String dishName;
    private String price;
    private String category;
    private String photoName;

    public MenuDtls() {
        super();
    }

    public MenuDtls(String dishName, String price, String category, String photoName) {
        this.dishName = dishName;
        this.price = price;
        this.category = category;
        this.photoName = photoName;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
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

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    public String toString() {
        return "MenuDtls{" +
                "dishId=" + dishId +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", photoName='" + photoName + '\'' +
                '}';
    }
}
