package com.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Facilita la conexion con la Base de Datos.

public class DataBaseUtil {

//jdbc:mysql://localhost:3306/nombreDB
//"com.mysql.cj.jdbc.Driver"
private static final String URL = "jdbc:mysql://localhost:3306/usuarios";
private static final String USER = "root";
private static final String PASSWORD = "";
private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


public static Connection getConnection() throws ClassNotFoundException, SQLException {
 
    //Validar si existe el Driver

    Class.forName(DRIVER);

    Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
    return connection;
}

public static void main(String[] args) {
    try {
        DataBaseUtil.getConnection();
        System.out.println("Conexion exitosa");
    } catch (ClassNotFoundException e) {
  
        e.printStackTrace();
        System.out.println("el driver no existe");
    } catch (SQLException e) {
     
        System.out.println("no se establecio la conexion a db");
    }
}

}
