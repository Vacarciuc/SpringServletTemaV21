package com.example.SpringServletTemaV21.database;

import com.example.SpringServletTemaV21.entities.Product;
import com.example.SpringServletTemaV21.entities.Sales;

import java.util.List;

public interface SalesDAO {
    //get all product for sales
    List<Product>fiindAll();

    public void addToCart(int id, int quantity);
    List<Sales>viewAll();

}
