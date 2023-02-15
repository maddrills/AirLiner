package com.prepairedStatements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementToAddFlightDataByAdmin extends PrepareStatementz {

    String airport_id_from,airport_id_to,date_of_departure;
    int cost;

    public PreparedStatementToAddFlightDataByAdmin(String airport_id_from,
                                                   String airport_id_to,
                                                   String date_of_departure,
                                                   int cost){
        this.airport_id_from = airport_id_from;
        this.airport_id_to = airport_id_to;
        this.date_of_departure = date_of_departure;
        this.cost = cost;

    }


    @Override
    public ResultSet resultSet() throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement("INSERT INTO flights (airport_id_from,airport_id_to,date_of_departure,cost)\n" +
                "SELECT ?,?,?,?\n;");

        preparedStatement.setString(1,airport_id_from);
        preparedStatement.setString(2,airport_id_to);
        preparedStatement.setString(3,date_of_departure);
        preparedStatement.setInt(4,cost);

        preparedStatement.execute();
        return null;
    }

    @Override
    void close() throws SQLException {

    }

/*    public static void main(String[] args) throws SQLException {
        PrepareStatementz preparedStatementToAddFlightDataByAdmin = new PreparedStatementToAddFlightDataByAdmin("4","5","2023-02-13");
        preparedStatementToAddFlightDataByAdmin.resultSet();
    }*/
}
