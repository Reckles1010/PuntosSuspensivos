package com.PuntosSuspensivos.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String oracleUrl = "jdbc:oracle:thin:@//localhost:1521/XEPDB1";

    private static final String mysqlUrl = "jdbc:mysql://localhost:3306/PuntosSuspensivos";

    private static final String userOracle = "user1";
    private static final String userSql = "root";
    private static final String password = "1234";

    private DataBaseConnection() {}

    public static Connection getOracleConnection() throws SQLException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(oracleUrl, userOracle, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver Oracle no encontrado", e);
        }
    }

    public static Connection getMySQLConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(mysqlUrl, userSql, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL no encontrado", e);
        }
    }

    public static Connection getConnection() throws SQLException{

        try {
            return getMySQLConnection();
        } catch (SQLException ignore) {
            System.out.println("No funciona MySQL");
            ignore.printStackTrace();
        }

        try {
            return getOracleConnection();
        } catch (SQLException ignore) {
            System.out.println("No funciona Oracle");
            ignore.printStackTrace();
        }

        System.out.println("MySQL driver loaded");
        throw new SQLException("No se pudo conectar ni a MySQL ni a Oracle");
    }
}