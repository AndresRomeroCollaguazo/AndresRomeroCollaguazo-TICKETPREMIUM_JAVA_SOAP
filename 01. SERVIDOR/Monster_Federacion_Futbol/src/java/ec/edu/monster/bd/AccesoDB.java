/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.monster.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {

    // Librería de MySQL
    public static String driver = "com.mysql.cj.jdbc.Driver";
    // Nombre de la base de datos
    public static String database = "ticketpremium";
    // Host
    public static String hostname = "ticketpremium.c7aqmeusexcf.us-east-2.rds.amazonaws.com";
    // Puerto
    public static String port = "3306";
    // Ruta de nuestra base de datos
    public static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?autoReconnect=true" + "&useSSL=false";
    // Nombre de usuario
    public static String username = "root";
    // Clave de usuario
    public static String password = "root1234";

    public AccesoDB() {
    }

    public static Connection getConnection() throws SQLException {
        Connection conectar = null;

        try {
            Class.forName(driver);
            conectar = DriverManager.getConnection(url, username, password);
            System.out.println("CONECTADO");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }

        return conectar;
    }
}
