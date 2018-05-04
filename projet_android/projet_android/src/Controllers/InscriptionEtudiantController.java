/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.EtudiantDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Classee;
import metier.Etudiantt;
import metier.Professeurr;
import vue.Projet_Android_interface;

/**
 *
 * @author Ludovic
 */
public class InscriptionEtudiantController {
    @FXML 
    TextField nomEtud;
    @FXML 
    TextField prenomEtud;
    @FXML 
    TextField mailEtud;
    @FXML 
    TextField ageEtud;
    @FXML 
    TextField filiere;
    @FXML 
    TextField sectionEtud;
    
    @FXML
    private Button bt_return;

    
    
    
    
    @FXML
  private void newEtudiant(ActionEvent actionEvent) throws SQLException
 {
      
     System.out.println(nomEtud.getText());
     
           Etudiantt Etud2  = new Etudiantt();
           Etud2.setnom(nomEtud.getText());
           Etud2.setprenom(prenomEtud.getText());
           Etud2.setemail(mailEtud.getText());
           Etud2.setage(Integer.valueOf(ageEtud.getText()));
           Classee cla = new Classee();
           cla.setfiliere(filiere.getText());
           cla.setsection(sectionEtud.getText());
           Etud2.setClasse(cla);
             System.out.println(Etud2.getClasse().getSection());
             System.out.println(Etud2.getClasse().getFiliere());
                  
             
             try{  
             EtudiantDAO.insertEtudiant(Etud2);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(InscriptionEtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

                        
 
@FXML
 private void CancelEtudiant (ActionEvent actionEvent){
       try{
        FXMLLoader loaderE = new FXMLLoader ();
        loaderE.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/welcomeFX.fxml"));
        AnchorPane anchorEtudiant =(AnchorPane) loaderE.load();
        Stage stage = (Stage) bt_return.getScene().getWindow();
        Scene scene = bt_return.getScene();
        scene.setRoot(anchorEtudiant);
        stage.setScene(scene);
    } 
        //Catch de CancelEtudiant 
        catch (IOException e){  
         }
       
       
}
}
