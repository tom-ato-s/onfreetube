package com.jdbs;

public class Product {

    private int id;
    private String name;
    private Double price;
    private int shopId;

    public Product () {}
    public Product(int id, String name, Double price, int shopId){
        this.id = id;
        this.name = name;
        this.price = price;
        this.shopId = shopId;
    }

    @Override   // вместо создания гетерров и сетерров

    public String toString() {
        return "Product: (" +id + "\t" + name + "\t" + price + "руб.\t" + shopId + ")";
    }
}
