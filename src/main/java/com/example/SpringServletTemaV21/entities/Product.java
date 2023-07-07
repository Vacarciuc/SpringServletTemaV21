package com.example.SpringServletTemaV21.entities;

public class Product {
    private int id;
    private String nameProduct;
    private String descriptionProduct;
    private int stock;
    private double price;


    public Product() {
    }
//using for rowMapper
    public Product(int id, String nameProduct, String descriptionProduct, int stock, double price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.descriptionProduct = descriptionProduct;
        this.stock = stock;
        this.price = price;
    }

    public Product(String descriptionProduct, double price) {
        this.descriptionProduct = descriptionProduct;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", descriptionProduct='" + descriptionProduct + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
