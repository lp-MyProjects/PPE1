/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import DAO.MatiereDAO;
import DAO.ProfesseurDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import metier.Matiere;
import metier.Professeurr;
import vue.Projet_Android_interface;



/**
 *
 * @author Ludovic
 */
public class ProfesseurController {
    @FXML 
    TextField nom ;
    @FXML 
    TextField mail ;
    @FXML
    ComboBox<Matiere> matiereCombox ;
    @FXML 
    private Button bt_returnWelcome;
    
    Matiere newMat ;
    
          
  



@FXML
private void initialize(){
    newMat   =  new Matiere();

    
        try {
            ObservableList<Matiere> empData = MatiereDAO.findMatiere()  ;
            matiereCombox.setItems(empData);
            
            StringConverter<Matiere> conv = new StringConverter<Matiere>() {
                            @Override
                            public Matiere fromString(String string) {
                            return null;
                            }
                            @Override
                            public String toString(Matiere clie) {
                            return clie.getIntitule();
                            }
                            };
            matiereCombox.setConverter(conv);
            matiereCombox.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Matiere> o, Matiere ol, Matiere nw) -> {
            
            newMat.setIntitule(matiereCombox.getValue().getIntitule());
           
             
            });
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
}
 @FXML
  private void newProfesseur(ActionEvent actionEvent)
 {
      System.out.println(nom.getText());
            
           Professeurr  prof2  = new Professeurr();
           prof2.setnomProfesseur(nom.getText());
             prof2.setemail(mail.getText());
          prof2.setMatiere(newMat);
            System.out.println(prof2.getMatiere().getIntitule());
         
     try {
            
            ProfesseurDAO.insertProfesseur(prof2);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
    } 
      @FXML
   private void goToWelcome (ActionEvent actionEvent){
       try{
        FXMLLoader loaderP = new FXMLLoader ();
        loaderP.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/welcomeFX.fxml"));
        AnchorPane anchorFormations =(AnchorPane) loaderP.load();
        Stage stage = (Stage) bt_returnWelcome.getScene().getWindow();
        Scene scene = bt_returnWelcome.getScene();
        scene.setRoot(anchorFormations);
        stage.setScene(scene);
    } 
         catch (IOException e){
             
         }
    }
    




}
