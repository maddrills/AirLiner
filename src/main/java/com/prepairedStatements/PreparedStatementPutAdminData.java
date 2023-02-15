package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementPutAdminData extends PrepareStatementz{

    private String adminName,adminPassword;


    public PreparedStatementPutAdminData(String adminName,String adminPassword){
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
    @Override
    public ResultSet resultSet() throws SQLException {

        PreparedStatement preparedStatement = getConnection().prepareStatement("" +
                "INSERT INTO admin(admin_name, admin_pass) VALUE (?,?);");

        preparedStatement.setString(1,adminName);
        preparedStatement.setString(2,adminPassword);
        preparedStatement.execute();
        return null;
    }

    @Override
    void close() throws SQLException {}

/*
    public static void main(String[] args) throws SQLException {
        PrepareStatementz prepareStatementz = new PreparedStatementPutAdminData("one","123");
        prepareStatementz.resultSet();
    }*/
}
