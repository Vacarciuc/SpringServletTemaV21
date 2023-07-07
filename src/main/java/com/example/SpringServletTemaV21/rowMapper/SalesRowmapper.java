package com.example.SpringServletTemaV21.rowMapper;

import com.example.SpringServletTemaV21.entities.Sales;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesRowmapper implements RowMapper<Sales> {
    @Override
    public Sales mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Sales(
                rs.getInt("id"),
                rs.getInt("id_client"),
                rs.getInt("id_produs"),
                rs.getInt("quantity")
        );
    }
}
