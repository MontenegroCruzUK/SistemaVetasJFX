/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.ComboBox;

/**
 *
 * @author montenegro
 */
public class ProductoDado {

    private HacerConexion hacerConexion = new HacerConexion();
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean registrarProducto(Producto producto) {
        String sql = "INSERT INTO productos (codigo, descripcion, proveedor, stock, precio) VALUES (?,?,?,?,?)";
        try {
            connection = hacerConexion.getConnection();
            ps = connection.prepareStatement(sql);

            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getProveedor());
            ps.setInt(4, producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            ps.execute();
            System.out.println("Nuevo proveedor registrado con exito");
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo registrar el producto\n" + e.toString());
            return false;
        }
    }

    public void preguntarProveedor(ComboBox<String> comBox_Proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
