/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import animatefx.animation.ZoomIn;
import com.sun.org.apache.xpath.internal.operations.Equals;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author montenegro
 */
public class SistemaController implements Initializable {

    @FXML
    private Button btn_NuevaVenta;
    @FXML
    private Button btn_Clientes;
    @FXML
    private Button btn_Proveedores;
    @FXML
    private Button btn_Producto;
    @FXML
    private Button btn_Ventas;
    @FXML
    private Button btn_Configuracion;
    @FXML
    private StackPane stackPnl_ContentArea;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarPane("/views/NuevaVentaView.fxml");

    }

    private void mostrarPane(String url) {
        try {
            Pane fxml = FXMLLoader.load(getClass().getResource(url));
            stackPnl_ContentArea.getChildren().removeAll();
            stackPnl_ContentArea.getChildren().setAll(fxml);

        } catch (IOException e) {
            Logger.getLogger(controllers.SistemaController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @FXML
    private void irAPane(ActionEvent event) {               
        
        if (event.getSource().equals(btn_NuevaVenta)) {
            mostrarPane("/views/NuevaVentaView.fxml");

        } else if (event.getSource().equals(btn_Clientes)) {
            mostrarPane("/views/ClientesView.fxml");

        } else if (event.getSource().equals(btn_Proveedores)) {
            mostrarPane("/views/ProveedoresView.fxml");

        } else if (event.getSource().equals(btn_Producto)) {
            mostrarPane("/views/ProductosView.fxml");

        } else if (event.getSource().equals(btn_Ventas)) {
            mostrarPane("/views/VentasView.fxml");

        } else if (event.getSource().equals(btn_Configuracion)) {
            mostrarPane("/views/ConfiguracionView.fxml");
        }

    }

}
