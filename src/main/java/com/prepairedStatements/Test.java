package com.prepairedStatements;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        ResultSet resultSet;


        /**/
        PrepareStatementz prepareStatementz = new PreparedStatementTest();

        resultSet = prepareStatementz.resultSet();

        while (resultSet.next()){
            System.out.println(resultSet.getString("user_name"));
            System.out.println(resultSet.getString("user_pass"));
        }
        resultSet.close();

        /**/
        prepareStatementz = new PreparedStatementGetUserPassword("UTest");

        resultSet = prepareStatementz.resultSet();

        while(resultSet.next()){
            System.out.println(resultSet.getString("users_id"));

            resultSet.getString("user_name");
            resultSet.getString("user_pass");
        }


        System.out.println("inserting data");
        prepareStatementz = new PreparedStatementPutUserData("two","123");

        System.out.println("Inserting data");


    }
}
