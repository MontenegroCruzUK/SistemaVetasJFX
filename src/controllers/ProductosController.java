/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Producto;
import models.ProductoDado;

/**
 * FXML Controller class
 *
 * @author montenegro
 */
public class ProductosController implements Initializable {

    @FXML
    private TextField txt_Codigo;
    @FXML
    private TextField txt_Id;
    @FXML
    private TextField txt_Descripcion;
    @FXML
    private TextField txt_Stock;
    @FXML
    private TextField txt_Precio;
    @FXML
    private ComboBox<String> comBox_Proveedor;
    @FXML
    private Button btn_Guardar;
    @FXML
    private Button btn_GenerarReporte;
    @FXML
    private TableView<Producto> table_Productos;
    @FXML
    private TableColumn tblCol_Id;
    @FXML
    private TableColumn tblCol_Codigo;
    @FXML
    private TableColumn tblCol_Descripcion;
    @FXML
    private TableColumn tblCol_Proveedor;
    @FXML
    private TableColumn tblCol_Stock;
    @FXML
    private TableColumn tblCol_Precio;
    @FXML
    private TableColumn tblCol_Accion;

    private ObservableList<Producto> producto;

    private Producto productos = new Producto();
    private ProductoDado productoDado = new ProductoDado();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        productoDado.preguntarProveedor(this.comBox_Proveedor);
        
        

        producto = FXCollections.observableArrayList();
        this.tblCol_Id.setCellValueFactory(new PropertyValueFactory("ID"));
        this.tblCol_Codigo.setCellValueFactory(new PropertyValueFactory("Codigo"));
        this.tblCol_Descripcion.setCellValueFactory(new PropertyValueFactory("Descripcion"));
        this.tblCol_Proveedor.setCellValueFactory(new PropertyValueFactory("Proveedor"));
        this.tblCol_Stock.setCellValueFactory(new PropertyValueFactory("Stock"));
        this.tblCol_Precio.setCellValueFactory(new PropertyValueFactory("Precio"));

    }

    @FXML
    private void guardar(ActionEvent event) {
        if (!"".equals(this.txt_Codigo.getText())
                || !"".equals(this.txt_Descripcion.getText())
                || !"".equals(this.comBox_Proveedor.getSelectionModel().getSelectedItem())
                || !"".equals(txt_Stock.getText())
                || !"".equals(txt_Precio.getText())) {

            productos.setCodigo(Integer.parseInt(this.txt_Codigo.getText()));
            productos.setDescripcion(this.txt_Descripcion.getText());
            productos.setProveedor(this.comBox_Proveedor.getSelectionModel().getSelectedItem());
            productos.setStock(Integer.parseInt(this.txt_Stock.getText()));
            productos.setPrecio(Double.parseDouble(this.txt_Precio.getText()));
            productoDado.registrarProducto(productos);
            limpiarTabla();
            limpiarCampos();
            motrarProductosEnTabla();
        }
    }

    private void limpiarTabla() {
        System.out.println("Estamos trabajando en ello");

    }

    private void limpiarCampos() {
        System.out.println("Estamos trabajando en ello");

    }

    private void motrarProductosEnTabla() {
        //int id = Integer.parseInt(this.txt_Id.getText());
        int id = 001;
        int codigo = Integer.parseInt(this.txt_Codigo.getText());
        String descripcion = this.txt_Descripcion.getText();
        //String proveedor = this.comBox_Proveedor.getSelectionModel().getSelectedItem();
        String proveedor = "Juan";
        int stock = Integer.parseInt(this.txt_Stock.getText());
        double precio = Double.parseDouble(this.txt_Precio.getText());

        Producto pro = new Producto(id, codigo, descripcion, proveedor, stock, precio);

        if (!this.producto.contains(pro)) {
            this.producto.add(pro);
            this.table_Productos.setItems(producto);
            System.out.println("Me estoy ejecutando");
        } else {
            System.out.println("Error");
        }

    }

}
