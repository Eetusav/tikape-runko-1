/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tikape.forum.daot;

/**
 *
 * @author Matti
 */
import java.sql.*;
import java.util.*;
import java.util.stream.*;
public class Database<T> {

    private boolean debug;
    private Connection connection;

    public Database(String address) throws Exception {
        this.connection = DriverManager.getConnection(address);
    }

    public void setDebugMode(boolean d) {
        debug = d;
    }
    
    private void debug(ResultSet rs) throws SQLException {
        int columns = rs.getMetaData().getColumnCount();
        for (int i = 0; i < columns; i++) {
            System.out.print(
                    rs.getObject(i + 1) + ":"
                    + rs.getMetaData().getColumnName(i + 1) + "  ");
        }

        System.out.println();
    }

    public int update(String updateQuery) throws SQLException {
        Statement stmt = connection.createStatement();
        int changes = stmt.executeUpdate(updateQuery);

        if (debug) {
            System.out.println("---");
            System.out.println(updateQuery);
            System.out.println("Changed rows: " + changes);
            System.out.println("---");
        }
        stmt.close();

        return changes;
    }

    public Connection getConnection() throws SQLException{
        return this.connection;
    }

}
