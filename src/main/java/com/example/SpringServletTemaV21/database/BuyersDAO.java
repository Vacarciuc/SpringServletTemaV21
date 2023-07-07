package com.example.SpringServletTemaV21.database;

import com.example.SpringServletTemaV21.entities.Buyers;
import com.example.SpringServletTemaV21.entities.Product;

import java.util.List;

public interface BuyersDAO {
    List<Buyers>findAll();
    public void insertNewBuyers(String name, String address);
    public void updateBuyers(Buyers buyers);
    public void deleteBuyers(int id);
}
