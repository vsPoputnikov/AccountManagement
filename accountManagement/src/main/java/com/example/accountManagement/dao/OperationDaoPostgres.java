package com.example.accountManagement.dao;

import com.example.accountManagement.model.Operation;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public class OperationDaoPostgres implements OperationDao {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public OperationDaoPostgres(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addOperation(long accountId, double amount, String type) {
        final String sql = "INSERT INTO operations(account_id, amount, type)" +
                " VALUES (:account_id, :amount, :type)";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("account_id", accountId)
                .addValue("amount", amount)
                .addValue("type", type);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public List<Operation> getUserAccountOperations(long accountId) {
        final String sql = "SELECT id, account_id, amount, type FROM operations" +
                " WHERE operations.account_id = :account_id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("account_id", accountId);

        return namedParameterJdbcTemplate.query(sql, params, (rs, i) -> {
            return new Operation(
                    Long.parseLong(rs.getString("id")),
                    Long.parseLong(rs.getString("account_id")),
                    rs.getString("type").toUpperCase(Locale.ROOT),
                    Double.parseDouble(rs.getString("amount"))
            );
        });
    }
}
