package com.PuntosSuspensivos.util;

import java.sql.*;

public class DataBaseConnection {
    private static String url = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";
    private static String user = "user1";
    private static String password = "1234";

    private DataBaseConnection() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
