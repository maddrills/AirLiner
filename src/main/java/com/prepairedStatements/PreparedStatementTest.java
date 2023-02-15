package com.prepairedStatements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTest extends PrepareStatementz{

    ResultSet resultSet;
    PreparedStatement preparedStatement;
    @Override
    public ResultSet resultSet() throws SQLException {
        try{
            preparedStatement = getConnection().prepareStatement("SELECT u.user_name,u.user_pass FROM users AS u");

            resultSet = preparedStatement.executeQuery();

        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    void close() throws SQLException {
        preparedStatement.close();
        resultSet.close();
    }
}
