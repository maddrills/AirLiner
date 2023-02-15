package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementPutUserData extends PrepareStatementz{

    private String userName,userPassword;

    public PreparedStatementPutUserData(String userName, String userPassword){
        this.userName = userName;
        this.userPassword = userPassword;
    }
    @Override
    public ResultSet resultSet() throws SQLException {

        PreparedStatement preparedStatement = getConnection().prepareStatement("" +
                "INSERT INTO users(user_name, user_pass) VALUE (?,?);");

        preparedStatement.setString(1,userName);
        preparedStatement.setString(2,userPassword);
        preparedStatement.execute();
        return null;
    }

    @Override
    void close() throws SQLException {}


/*    public static void main(String[] args) throws SQLException {
        PrepareStatementz prepareStatementz = new PreparedStatementPutUserData("one","123");
        prepareStatementz.resultSet();
    }*/
}
