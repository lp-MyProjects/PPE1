/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ClasseDAO;
import DAO.MatiereDAO;
import DAO.ProfesseurDAO;
import DAO.SeanceDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.util.StringConverter;
import metier.Classee;
import metier.Matiere;

import metier.Professeurr;
import metier.Seancee;
import vue.Projet_Android_interface;

/**
 *
 * @author Ludovic
 */


public class SeanceeController {
    
    @FXML
    ComboBox <Professeurr> ComboxNomProf ;
    @FXML
    ComboBox<Classee>ComboxFiliere;
    @FXML
    ComboBox<Classee>ComboxAnnee;
    @FXML
    ComboBox<Classee>ComboxSection; 
    @FXML
    ComboBox<Matiere>ComboxMatiere;
    @FXML
    TextField dureeCours ;
    @FXML
    DatePicker dateSceance ;
    @FXML 
    private Button btn_return;
   @FXML
   private Button ajoutSeance;
    
    
    @FXML  
    Seancee nwSeanc;
       

        @FXML 
    private void ajoutSeance (ActionEvent actionEvent) throws SQLException, ClassNotFoundException{
        try{
            
            
      Professeurr prof = ComboxNomProf.getValue();
       LocalDate date =  dateSceance.getValue() ; 
      
       Matiere mat = ComboxMatiere.getValue();
      
       Classee cla = ComboxSection.getValue();
       
     double duree = Double.valueOf(dureeCours.getText());
       
 
       
       
       
       Seancee seanc1 = new Seancee();
        
           seanc1.setProf(prof);
           seanc1.setMat(mat);
           seanc1.setC(cla);
           seanc1.setdate(date);
           seanc1.setduree(duree);
          
         
             SeanceDAO.insertSeance(seanc1);
            
         } catch (SQLException | ClassNotFoundException ex) {
             
            
        }
            
    
    } 
    
    
    @FXML
    private void takeWelcome (ActionEvent actionEvent){
       try{
        FXMLLoader loaderE = new FXMLLoader ();
        loaderE.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/welcomeFX.fxml"));
        AnchorPane anchorSeance =(AnchorPane) loaderE.load();
        Stage stage = (Stage) btn_return.getScene().getWindow();
        Scene scene = btn_return.getScene();
        scene.setRoot(anchorSeance);
        stage.setScene(scene);
    } catch (IOException e){
             
         }
         }

@FXML
private void initialize() {
    
  Matiere mat  = new Matiere();
  Classee classe= new Classee();
  
   try {
    ObservableList<Classee> empDataF = ClasseDAO.findClasse()  ;
    
              ComboxFiliere.setItems(empDataF);
            
            
            StringConverter<Classee> convFiliere = new StringConverter<Classee>() {
                            @Override
                            public Classee fromString(String stringF) {
                            return null;
                            }
                            @Override
                            public String toString(Classee clF) {
                            return clF.getFiliere();
                            }
                             }; 
                           
           
            ObservableList<Classee> empDataS = ClasseDAO.findClasse()  ;
            ComboxSection.setItems(empDataS);
            StringConverter<Classee> convSection = new StringConverter<Classee>() {
                            @Override
                            public Classee fromString(String stringS) {
                            return null;
                            }
                            @Override
                            public String toString(Classee clS) {
                            return clS.toString();
                            }
    
               }; 
             ObservableList<Classee> empDataAn = ClasseDAO.findClasse()  ;
           ComboxAnnee.setItems(empDataAn);
            StringConverter<Classee> convAnnee = new StringConverter<Classee>() {
                           @Override
                           public Classee fromString(String stringAn) {
                           return null;
                            }
                           @Override
                           public String toString(Classee clA) {
                           return String.valueOf(clA.getAnnee());
                            }
    
              };  
             ObservableList<Professeurr> empDataP = ProfesseurDAO.findProf()  ;
            ComboxNomProf.setItems(empDataP);
            StringConverter<Professeurr> convProf = new StringConverter<Professeurr>() {
                            @Override
                            public Professeurr fromString(String stringP) {
                            return null;
                            }
                            @Override
                            public String toString(Professeurr clP) {
                            return clP.getnomProfesseur();
                            }
            
            };
   
            ComboxFiliere.setConverter(convFiliere);
            ComboxSection.setConverter(convSection);
            ComboxNomProf.setConverter(convProf);
            ComboxAnnee.setConverter(convAnnee);
            
            ComboxNomProf.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Professeurr> o,Professeurr ol, Professeurr nw) -> {
            
            mat.setIntitule(ComboxNomProf.getValue().getMatiere().getIntitule());});
            
      /*   ComboxFiliere.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Classee> o,Classee ol, Classee nw) -> {
            
         classe.setfiliere(ComboxFiliere.getValue().getFiliere());
         classe.setsection(ComboxSection.getValue().getSection());
         classe.setannee(ComboxAnnee.getValue().getAnnee());
         }
                   );
        ComboxSection.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Classee> o,Classee ol, Classee nw) -> {
            
       
         classe.setsection(ComboxSection.getValue().getSection());
         
         }
              
                   );
        
        */
         ObservableList<Matiere> empDataM = MatiereDAO.findMatiere() ;
            ComboxMatiere.setItems(empDataM);
          
        
   }
  catch (ClassNotFoundException | SQLException ex) {
Logger.getLogger(ClasseeController.class.getName()).log(Level.SEVERE, null, ex);
             }


}
}



      

     

