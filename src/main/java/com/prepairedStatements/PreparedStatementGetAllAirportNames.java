package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementGetAllAirportNames extends PrepareStatementz{
    @Override
    public ResultSet resultSet() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT airport_id,airport_name,city,country FROM Airport;");
        return preparedStatement.executeQuery();
    }

    @Override
    void close() throws SQLException {
    }

/*    public static void main(String[] args) throws SQLException {
        PreparedStatementGetAllAirportNames preparedStatementGetAllAirportNames = new PreparedStatementGetAllAirportNames();
        ResultSet resultSet = preparedStatementGetAllAirportNames.resultSet();
        while (resultSet.next()){
            System.out.println(resultSet.getString("airport_name"));
        }

        System.out.println("   ");

        PreparedStatementGetAllAirportNames preparedStatementGetAllAirportNames2 = new PreparedStatementGetAllAirportNames();
        ResultSet resultSet2 = preparedStatementGetAllAirportNames2.resultSet();
        while (resultSet2.next()){
            System.out.println(resultSet2.getString("airport_name"));
        }
    }*/
}
