/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import animatefx.animation.*;
import java.io.IOException;
import javafx.scene.control.Button;
import models.Login;
import models.LoginDado;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author montenegro
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private Pane pnl_Ingresar;
    @FXML
    private PasswordField txt_Password;
    @FXML
    private Label lb_PassOdvidado;
    @FXML
    private Pane pnl_RecuperarPass;
    @FXML
    private ImageView btn_Atras;
    @FXML
    private Button btn_Ingresar;
    @FXML
    private TextField txt_Correo;

    Login login = new Login();
    LoginDado loginDado = new LoginDado();

    public LoginController() {
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void irAInicio(MouseEvent event) {
        if (event.getSource().equals(btn_Atras)) {
            new ZoomIn(pnl_Ingresar).play();
            pnl_Ingresar.toFront();
        }

    }

    @FXML
    private void recuperarPass(MouseEvent event) {
        if (event.getSource().equals(lb_PassOdvidado)) {
            new ZoomIn(pnl_RecuperarPass).play();
            pnl_RecuperarPass.toFront();
        }
    }

    @FXML
    private void ingresar() {
        String correo = this.txt_Correo.getText();
        String password = String.valueOf(this.txt_Password.getText());

        if (!"".equals(correo) || !"".equals(password)) {

            login = loginDado.setLogin(correo, password);

            if (login.getCorreo() != null && login.getPassword() != null) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/SistemaView.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    Stage myStage = (Stage) this.btn_Ingresar.getScene().getWindow();
                    myStage.close();

                } catch (IOException e) {
                    System.out.println("Error en el boton de conectar");
                }
            } else {
                System.out.println("me ejecuto por que quiero");
            }
        } else {
            System.out.println("estoy aqui no se por que razon");
        }
    }

}
