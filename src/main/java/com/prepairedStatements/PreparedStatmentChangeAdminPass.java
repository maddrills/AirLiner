package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatmentChangeAdminPass extends PrepareStatementz{

    String pass; String Id;

    public PreparedStatmentChangeAdminPass(String pass, String Id){
        this.pass = pass;
        this.Id = Id;
    }
    @Override
    public ResultSet resultSet() throws SQLException {

        PreparedStatement preparedStatement = getConnection().
                prepareStatement("UPDATE admin SET admin_pass = ? WHERE admin_id = ?;");

        preparedStatement.setString(1,pass);
        preparedStatement.setString(2,Id);
        preparedStatement.execute();

        return null;
    }

    @Override
    void close() throws SQLException {

    }

    public static void main(String [] args) throws SQLException {
        PreparedStatmentChangeAdminPass preparedStatmentChangeAdminPass = new PreparedStatmentChangeAdminPass("wanker","4");
        preparedStatmentChangeAdminPass.resultSet();
    }

}
