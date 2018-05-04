/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.EtudiantDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import metier.Classee;
import metier.Etudiant;
import metier.Etudiantt;

/**
 *
 * @author Ludovic
 */
public class EtudiantController {
    
   
     @FXML 
    TextField nom ;
      @FXML 
    TextField prenom ;
       @FXML 
    TextField email ;
        @FXML
    TextField classe ;
         @FXML 
    TextField section ;
       
         private void inscriptionEtudiant(ActionEvent actionEvent) {
         try {
             Classee cla1 = new Classee();
             Etudiantt etud  = new Etudiantt();
             
             etud.setnom(nom.getText());
             etud.setemail(prenom.getText());
             etud.setemail(email.getText());
             
             
            
            EtudiantDAO.insertEtudiant(etud);
         } catch (SQLException ex) {
             Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
         
         
         }
    
    
}
