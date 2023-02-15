package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementGetFlightDataByDate extends PrepareStatementz{

    String from,to,date;

    public PreparedStatementGetFlightDataByDate(String from,String to,String date){

        this.from = from;
        this.to = to;
        this.date = date;
    }


    @Override
    public ResultSet resultSet() throws SQLException {

        PreparedStatement preparedStatement = getConnection().prepareStatement("SELECT fli.flights_id,airFrom.airport_name AS fromAir,airTo.airport_name AS toAir,fli.date_of_departure\n" +
                "FROM flights as fli\n" +
                "    JOIN Airport AS airFrom ON fli.airport_id_from = airFrom.airport_id\n" +
                "    JOIN Airport AS airTo ON airTo.airport_id = fli.airport_id_to\n" +
                "WHERE fli.date_of_departure = ?\n" +
                "  AND airFrom.airport_id = ?\n" +
                "  AND airTo.airport_id = ?;\n");


        preparedStatement.setString(1,date);
        preparedStatement.setString(2,from);
        preparedStatement.setString(3,to);

        return preparedStatement.executeQuery();
    }

    @Override
    void close() throws SQLException {

    }

    public static void main(String[] args) throws SQLException {

        PrepareStatementz preparedStatementGetFlightDataByDate = new PreparedStatementGetFlightDataByDate("1","5","2023-02-17");

        ResultSet resultSet = preparedStatementGetFlightDataByDate.resultSet();

        while (resultSet.next()){
            System.out.println(            resultSet.getString("fromAir"));
            System.out.println(            resultSet.getString("toAir"));
            System.out.println(            resultSet.getString("date_of_departure"));
        }
    }
}
