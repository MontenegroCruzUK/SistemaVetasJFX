/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author montenegro
 */
public class HacerConexion {

    Connection connection;
    Mensajes mensaje = new Mensajes();

    public Connection getConnection() {
        try {
            String url = "jdbc:sqlite:/home/montenegro/NetBeansProjects/SistemaVentasJFX/db/db_SistemaVentas";
            connection = DriverManager.getConnection(url);
            //mensaje.alertaInformacion("Se hizo la conexion");
            System.out.println("Se pudo acceder a la URL: " + url);
            return connection;
        } catch (SQLException e) {
            System.out.println("todo mal");
            mensaje.alertaError("No se pudo hacer la conexion");
            System.out.println("Error en la Clase HacerConexion: " + e.toString());
            return null;
        }

    }

}
