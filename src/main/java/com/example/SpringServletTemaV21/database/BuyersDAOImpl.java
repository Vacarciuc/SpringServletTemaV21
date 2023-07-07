package com.example.SpringServletTemaV21.database;

import com.example.SpringServletTemaV21.entities.Buyers;
import com.example.SpringServletTemaV21.entities.Product;
import com.example.SpringServletTemaV21.rowMapper.BuyersRowmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public class BuyersDAOImpl implements BuyersDAO{

    @Autowired
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BuyersDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Buyers> findAll() {
        String querry="select*from buyers;";
        return jdbcTemplate.query(querry, new BuyersRowmapper());
    }

    @Override
    public void insertNewBuyers(String name, String address) {
        String querry="insert into buyers values(null, '"+name+"', '"+address+"');";
            jdbcTemplate.execute(querry);
    }

    @Override
    public void updateBuyers(Buyers buyers) {
        String querry="update buyers set name_client='"+buyers.getNameClient()+"', " +
                "address='"+buyers.getAddress()+"' where id="+buyers.getId()+";";
        jdbcTemplate.execute(querry);
    }

    @Override
    public void deleteBuyers(int id) {
        String querry="delete from buyers where id="+id+";";
        jdbcTemplate.execute(querry);
    }
}
