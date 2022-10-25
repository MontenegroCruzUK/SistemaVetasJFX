/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author montenegro
 */
public class LoginDado {

    Connection connection;
    PreparedStatement ps;
    ResultSet rs;
    HacerConexion hacerConexion = new HacerConexion();
    Login login = new Login();
    Mensajes mensaje = new Mensajes();

    public Login setLogin(String correo, String password) {
        System.out.println("Iniciando setLogin");
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND password = ?";
        try {
            connection = hacerConexion.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                login.setId(rs.getInt("id"));
                login.setCorreo(rs.getString("nombre"));
                login.setPassword(rs.getString("password"));
                mensaje.alertaInformacion("Todo ");
            }

        } catch (SQLException e) {
            mensaje.alertaError("Algo Salio Mal");
            System.out.println("Error: "+e.toString());
        }
        System.out.println("Cerrando setLogin");
        return login;

    }

}
