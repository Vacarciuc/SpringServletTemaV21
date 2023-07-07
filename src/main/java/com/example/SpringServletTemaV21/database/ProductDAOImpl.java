package com.example.SpringServletTemaV21.database;

import com.example.SpringServletTemaV21.entities.Product;
import com.example.SpringServletTemaV21.rowMapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDAOImpl implements ProductDAO {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> fiindAll() {
        String querry="select*from product;";
        return jdbcTemplate.query(querry, new ProductRowMapper());
    }

    @Override
    public void insertNewProduct(String name, String description, int stock, double price) {
        String querry="insert into product values(null, '"+name+"', '"+description+"', "+stock+", "+price+");";
        jdbcTemplate.execute(querry);
    }

    @Override
    public void uodateProduct(Product product) {
        String querry="update product set name_product='"+product.getNameProduct()+"', " +
                "description_product='"+product.getDescriptionProduct()+"', stock="+product.getStock()+", " +
                "price="+product.getPrice()+" where id="+product.getId()+";";
        jdbcTemplate.execute(querry);
    }

    @Override
    public void deleteProduct(int id) {
        String querry="delete from product where id="+id+";";
        jdbcTemplate.execute(querry);
    }
}
