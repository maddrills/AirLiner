package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepairedStatementGetAllFlightDataByFlightId extends PrepareStatementz{

    String flights_id;

    public PrepairedStatementGetAllFlightDataByFlightId(String flights_id){
        this.flights_id = flights_id;
    }


    @Override
    public ResultSet resultSet() throws SQLException {

        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT fli.flights_id,airFrom.airport_name AS fromAir,airTo.airport_name AS toAir,fli.date_of_departure,fli.cost\n" +
                "FROM flights as fli\n" +
                "    JOIN Airport AS airFrom ON fli.airport_id_from = airFrom.airport_id\n" +
                "    JOIN Airport AS airTo ON airTo.airport_id = fli.airport_id_to\n" +
                "WHERE fli.flights_id = ?;");


        preparedStatement.setString(1,flights_id);

        return preparedStatement.executeQuery();
    }

    @Override
    void close() throws SQLException {

    }

    public static void main(String[] args) throws SQLException {

        PrepareStatementz prepairedStatementGetAllFlightDataByFlightId = new PrepairedStatementGetAllFlightDataByFlightId("10");

        ResultSet resultSet = prepairedStatementGetAllFlightDataByFlightId.resultSet();

        while (resultSet.next()){
            System.out.println(            resultSet.getString("fromAir"));
            System.out.println(            resultSet.getString("toAir"));
            System.out.println(            resultSet.getString("date_of_departure"));
        }
    }
}
