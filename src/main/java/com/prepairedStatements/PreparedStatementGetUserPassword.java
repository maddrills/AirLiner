package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementGetUserPassword extends PrepareStatementz{

    private final String userName;

    public PreparedStatementGetUserPassword(String userName){
        this.userName = userName;
    }

    @Override
    public ResultSet resultSet() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("" +
                "SELECT u.users_id,u.user_name,u.user_pass \n" +
                "FROM users AS u \n" +
                "WHERE user_name = ?;");

        preparedStatement.setString(1,userName);

        return preparedStatement.executeQuery();
    }

    @Override
    void close() throws SQLException {}
}
