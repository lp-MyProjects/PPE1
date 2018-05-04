/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vue.Projet_Android_interface;

/**
 * FXML Controller class
 *
 * @author Ludovic
 */

public class NosFormationsController{

    @FXML
private Button bt_goBack;

@FXML
 private void goBack ( ActionEvent actionEvent){
       try{
        FXMLLoader loaderAcc = new FXMLLoader ();
        loaderAcc.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/welcomeFX.fxml"));
        AnchorPane anchorFormations =(AnchorPane) loaderAcc.load();
        Stage stage = (Stage) bt_goBack.getScene().getWindow();
        Scene scene = bt_goBack.getScene();
        scene.setRoot(anchorFormations);
        stage.setScene(scene);
    } 
         catch (IOException e){
             
         }
    }
    
}
