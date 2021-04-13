package com.example.accountManagement.dao;

import com.example.accountManagement.model.User;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoPostgres implements UserDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserDaoPostgres(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public int addUser(String fullName) {
        final String sql = "INSERT INTO customer(full_name) VALUES (:full_name)";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("full_name", fullName);
        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteUserById(long id) {
        final String sql = "DELETE FROM customer_account WHERE customer_id = :id;" +
                "DELETE FROM customer WHERE id = :id;";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", id);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public List<User> getAllUsers() {
        final String sql = "SELECT id, full_name FROM customer";

        return namedParameterJdbcTemplate.query(sql, (rs, i) -> {
            return new User(Long.parseLong(rs.getString("id")), rs.getString("full_name"));
        });
    }
}
