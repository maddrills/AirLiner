package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementGetFlightDataAll extends PrepareStatementz{
    @Override
    public ResultSet resultSet() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT fli.flights_id,airFrom.airport_name AS airFrom,airTo.airport_name AS airTo,fli.date_of_departure,fli.cost FROM flights as fli\n" +
                "    JOIN Airport AS airFrom ON fli.airport_id_from = airFrom.airport_id\n" +
                "    JOIN Airport AS airTo ON airTo.airport_id = fli.airport_id_to;\n");
        return preparedStatement.executeQuery();
    }

    @Override
    void close() throws SQLException {

    }
    public static void main(String[] args) throws SQLException {
        PreparedStatementGetFlightDataAll preparedStatementGetFlightDataAll = new PreparedStatementGetFlightDataAll();
        ResultSet resultSet = preparedStatementGetFlightDataAll.resultSet();

        try{
            while(resultSet.next()){
                System.out.println(resultSet.getString("airFrom"));
                System.out.println(resultSet.getString("airTo"));
                System.out.println(resultSet.getString("date_of_departure"));
            }
        }catch (Exception e){
            System.out.println("no data ");
        }
    }
}
