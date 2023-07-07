package com.example.SpringServletTemaV21.rowMapper;

import com.example.SpringServletTemaV21.entities.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                rs.getInt("id"),
                rs.getString("name_product"),
                rs.getString("description_product"),
                rs.getInt("stock"),
                rs.getDouble("price")
        );
    }
}
