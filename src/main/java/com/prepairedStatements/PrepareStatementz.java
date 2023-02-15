package com.prepairedStatements;
import com.connection.DataBaseConnection3306Proxy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//a strategy pattern for executing different queries
public abstract class PrepareStatementz {
    private Connection connection;
    public PrepareStatementz(){
        this.connection = DataBaseConnection3306Proxy.dataBaseConnection3306Proxy();
    }

    public Connection getConnection(){
        return this.connection;
    }
    public abstract ResultSet resultSet() throws SQLException;
    abstract void close() throws SQLException;
}


