package Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vue.Projet_Android_interface;



  
public class WelcomeFXController{
   
 
    @FXML
    private Button  bt_Formations ;
    @FXML
    private Button bt_Professeurs;
    @FXML 
    private Button bt_Cours;
    @FXML
    private Button bt_Etudiants;
     @FXML
    private Button bt_seance;
    
    @FXML
    private void goFormations (ActionEvent actionEvent){
       try{
        FXMLLoader loader = new FXMLLoader ();
        loader.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/nosFormations.fxml"));
        AnchorPane anchorWelcome =(AnchorPane) loader.load();
        Stage stage = (Stage) bt_Formations.getScene().getWindow();
        Scene scene = bt_Formations.getScene();
        scene.setRoot(anchorWelcome);
        stage.setScene(scene);
    } 
         catch (IOException e){
             
         }
    }
       @FXML
        private void goProfesseurs (ActionEvent actionEvent){
       try{
        FXMLLoader loaderP = new FXMLLoader ();
        loaderP.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/InscriptionProfesseur.fxml"));
        AnchorPane anchorWelcome =(AnchorPane) loaderP.load();
        Stage stage = (Stage) bt_Professeurs.getScene().getWindow();
        Scene scene = bt_Professeurs.getScene();
        scene.setRoot(anchorWelcome);
        stage.setScene(scene);
          
    } 
       
       catch (IOException e){
    } 
        }
        @FXML
         private void goCours (ActionEvent actionEvent){
       try{
        FXMLLoader loaderC = new FXMLLoader ();
        loaderC.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/nosCours.fxml"));
        AnchorPane anchorWelcome =(AnchorPane) loaderC.load();
        Stage stage = (Stage) bt_Cours.getScene().getWindow();
        Scene scene = bt_Cours.getScene();
        scene.setRoot(anchorWelcome);
        stage.setScene(scene);
          
    } 
         
       catch (IOException e){
    } 
         } 
         @FXML
            private void goEtudiant (ActionEvent actionEvent){
       try {
        FXMLLoader loaderE = new FXMLLoader ();
        loaderE.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/inscriptionEtudiant.fxml"));
        AnchorPane anchorWelcome =(AnchorPane) loaderE.load();
        Stage stage = (Stage) bt_Etudiants.getScene().getWindow();
        Scene scene = bt_Etudiants.getScene();
        scene.setRoot(anchorWelcome);
        stage.setScene(scene);
          
    } 
                
            
            
       catch (IOException e){
    } 
            }
                     @FXML
            private void goSeance (ActionEvent actionEvent){
       try {
        FXMLLoader loaderE = new FXMLLoader ();
        loaderE.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/Seance.fxml"));
        AnchorPane anchorWelcome =(AnchorPane) loaderE.load();
        Stage stage = (Stage) bt_seance.getScene().getWindow();
        Scene scene = bt_seance.getScene();
        scene.setRoot(anchorWelcome);
        stage.setScene(scene);
          
    } 
                
            
            
       catch (IOException e){
    } 
            }
@FXML
private void initialize(){
    
}
         }

