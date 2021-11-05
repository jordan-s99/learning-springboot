package com.jordan.dog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DogRowMapper implements RowMapper<Dog> {


    @Override
    public Dog mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Dog(resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getString("breed"),
                resultSet.getString("favouritetoy")
        );

    }
}
