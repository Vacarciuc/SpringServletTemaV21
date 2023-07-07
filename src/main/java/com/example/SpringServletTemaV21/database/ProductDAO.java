package com.example.SpringServletTemaV21.database;

import com.example.SpringServletTemaV21.entities.Product;

import java.util.List;

public interface ProductDAO {
    /**prpduct function*/
    //get all product from product table
    List<Product>fiindAll();
    //insert new product from product table
    public void insertNewProduct(String name, String description, int stock, double price);
    //update product from product table by id
    public void uodateProduct(Product product);
    //delete product from product table by id
    public void deleteProduct(int id);

}
