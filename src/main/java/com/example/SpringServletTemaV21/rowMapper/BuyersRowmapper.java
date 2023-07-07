package com.example.SpringServletTemaV21.rowMapper;

import com.example.SpringServletTemaV21.entities.Buyers;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BuyersRowmapper implements RowMapper<Buyers> {
    @Override
    public Buyers mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Buyers(
                rs.getInt("id"),
                rs.getString("name_client"),
                rs.getString("address")
        );
    }
}
