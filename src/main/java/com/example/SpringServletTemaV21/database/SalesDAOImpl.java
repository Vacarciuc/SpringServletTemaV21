package com.example.SpringServletTemaV21.database;

import com.example.SpringServletTemaV21.entities.Buyers;
import com.example.SpringServletTemaV21.entities.Product;
import com.example.SpringServletTemaV21.entities.Sales;
import com.example.SpringServletTemaV21.rowMapper.BuyersRowmapper;
import com.example.SpringServletTemaV21.rowMapper.ProductRowMapper;
import com.example.SpringServletTemaV21.rowMapper.SalesRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class SalesDAOImpl implements SalesDAO{

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public List<Product> fiindAll() {
        String querry="select*from product";
        return jdbcTemplate.query(querry, new ProductRowMapper());
    }

    @Override
    public void addToCart(int id, int quantity) {
        List<Product>productList=new ArrayList<>();
        // get product
        String querry="select*from product where id="+id+"";
        productList=jdbcTemplate.query(querry, new ProductRowMapper());
        Product product=new Product();
        for(Product list:productList){
            product.setId(list.getId());
            product.setNameProduct(list.getNameProduct());
            product.setDescriptionProduct(list.getDescriptionProduct());
            product.setStock(list.getStock());
            product.setPrice(list.getPrice());
        }
        //insert product into sales
        //get function for id_client
        /**clientul ar trebui sa se logheze pentru a obtine un id personal*/
        String queryLastInsert="select * from buyers";
        List<Buyers>buyersList=new ArrayList<>();
        buyersList=jdbcTemplate.query(queryLastInsert, new BuyersRowmapper());
        Buyers buyers=new Buyers();
        for (Buyers buyer: buyersList){
            buyers.setId(buyer.getId());
            buyers.setNameClient(buyer.getNameClient());
            buyers.setAddress(buyer.getAddress());
        }
        String querryInsertSales="insert into sales values(null, "+buyers.getId()+", " +
                ""+product.getId()+", "+quantity+");";
        jdbcTemplate.execute(querryInsertSales);
        //update stock from product
        int newStock=product.getStock()-quantity;
        String querryUpdate="update product set stock="+newStock+" where id="+id+"";
        jdbcTemplate.execute(querryUpdate);

    }
    @Override
    public List<Sales> viewAll() {
        String querry="select*from sales;";
        return jdbcTemplate.query(querry, new SalesRowmapper());
    }
}
