package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementGetAdminPassword extends PrepareStatementz{

    private final String adminName;

    public PreparedStatementGetAdminPassword(String adminName){
        this.adminName = adminName;
    }

    @Override
    public ResultSet resultSet() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT a.admin_id,a.admin_name,a.admin_pass\n" +
                "FROM admin AS a\n" +
                "WHERE a.admin_name = ?;");

        preparedStatement.setString(1,adminName);

        return preparedStatement.executeQuery();
    }

    @Override
    void close() throws SQLException {

    }
}
