package com.connection;

import java.sql.Connection;

public class DataBaseConnection3306Proxy{

    private DataBaseConnection3306 dataBaseConnection3306;
    //singleton design pattern
    private static DataBaseConnection3306Proxy dataBaseConnection3306Proxy;

    private DataBaseConnection3306Proxy(){
    }

    //a proxy for 3306 port
    public Connection getConnection() {
        if(dataBaseConnection3306 == null){
            dataBaseConnection3306 = new DataBaseConnection3306();
            return dataBaseConnection3306.getConnection();
        }
        else {
            return dataBaseConnection3306.getConnection();
        }
    }

    //returns a single instance of this proxy connection
    public static Connection dataBaseConnection3306Proxy(){
        if(dataBaseConnection3306Proxy == null){
            dataBaseConnection3306Proxy = new DataBaseConnection3306Proxy();
        }
        return dataBaseConnection3306Proxy.getConnection();
    }

/*    public static void main(String[] args){
         Connection connection = DataBaseConnection3306Proxy.dataBaseConnection3306Proxy();
         System.out.println(connection);
    }*/
}
