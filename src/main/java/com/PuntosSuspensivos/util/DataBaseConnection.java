package com.PuntosSuspensivos.Util;

import java.sql.*;

public class DataBaseConnection {
    private static String url1 = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static String url2 = "jdbc:oracle:thin:@//localhost:3307/XEPDB1";
    private static String user = "user1";
    private static String password = "1234";

    private DataBaseConnection() {}


    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(url1, user, password);
        }catch(SQLException ex){
            return DriverManager.getConnection(url2, user, password);
        }
    }
}
