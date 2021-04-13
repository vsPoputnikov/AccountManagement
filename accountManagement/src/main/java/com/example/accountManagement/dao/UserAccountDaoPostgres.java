package com.example.accountManagement.dao;

import com.example.accountManagement.model.UserAccount;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserAccountDaoPostgres implements UserAccountDao {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserAccountDaoPostgres(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addUserAccount(long userId) {
        final String sql = "INSERT INTO customer_account(customer_id) VALUES (:customer_id)";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("customer_id", userId);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void deleteUserAccountByAccountId(long accountId) {
        final String sql = "DELETE FROM customer_account WHERE id = :id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", accountId);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public List<UserAccount> getUserAccounts(long userId) {
        final String sql = "SELECT id, customer_id, balance FROM customer_account" +
                " WHERE customer_account.customer_id = :id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("id", userId);

        return namedParameterJdbcTemplate.query(sql, params, (rs, i) -> {
            return new UserAccount(
                    Long.parseLong(rs.getString("id")),
                    Long.parseLong(rs.getString("customer_id")),
                    Double.parseDouble(rs.getString("balance")));
        });
    }

    @Override
    public void deposit(long accountId, double amount) {
        final String sql = "UPDATE customer_account SET balance = balance + :amount" +
                " WHERE customer_account.id = :account_id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("amount", amount)
                .addValue("account_id", accountId);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void withdraw(long accountId, double amount) {
        final String sql = "UPDATE customer_account SET balance = balance - :amount" +
                " WHERE customer_account.id = :account_id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("amount", amount)
                .addValue("account_id", accountId);
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public double getUserAccountBalance(long accountId) {
        final String sql = "SELECT customer_account.balance FROM customer_account" +
                " WHERE customer_account.id = :account_id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("account_id", accountId);

        return namedParameterJdbcTemplate.queryForObject(sql, params, Double.class);
    }

    @Override
    public double getUserBalance(long userId) {
        final String sql = "SELECT COALESCE(SUM(balance),0) FROM customer_account" +
                " WHERE customer_account.customer_id = :user_id";
        final MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("user_id", userId);

        return namedParameterJdbcTemplate.queryForObject(sql, params, Double.class);
    }


}
