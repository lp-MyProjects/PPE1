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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import metier.Classee;
import metier.Matiere;
import metier.Professeurr;
import metier.Seancee;
import vue.Projet_Android_interface;

/**
 * FXML Controller class
 *
 * @author Ludovic
 */
public class NosCoursController{
@FXML
private TableView <Seancee> showCours;
@FXML
private TableColumn<Seancee, String> colMatiere;
@FXML
private TableColumn<Seancee, String> colProfesseur;
@FXML
private TableColumn<Seancee, String> colFiliere;
@FXML
private TableColumn<Seancee, String> colSection;
@FXML
private TableColumn<Seancee, Double> colDuree;
@FXML
private TableColumn<Seancee, LocalDate> colDate;

@FXML 
private Button BtnRetour;

   
    @FXML
    private void searchMatiere(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
        ObservableList<Seancee> empDateM = SeanceDAO.findAllSeance();
        showCours.setItems(empDateM);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void searchProf(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all User information
            ObservableList<Seancee> empDataPr = SeanceDAO.findAllSeance();
            //Populate Employees on TableView
            showCours.setItems(empDataPr);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void searchFiliere(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all User information
            ObservableList<Seancee> empDataF = SeanceDAO.findAllSeance();
            //Populate Employees on TableView
            showCours.setItems(empDataF);
        } catch (SQLException e){
            System.out.println("Error occurred while getting employees information from DB.\n" + e);
            throw e;
        }
    }
    @FXML
    private void searchSection(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
     
    }


@FXML
 private void welcomeBack (ActionEvent actionEvent){
       try{
        FXMLLoader loaderC = new FXMLLoader ();
        loaderC.setLocation(Projet_Android_interface.class.getClassLoader().getResource("Interface/welcomeFX.fxml"));
        AnchorPane anchorNosCours =(AnchorPane) loaderC.load();
        Stage stage = (Stage) BtnRetour.getScene().getWindow();
        Scene scene = BtnRetour.getScene();
        scene.setRoot(anchorNosCours);
        stage.setScene(scene);
    } 
         catch (IOException e){
             
         }
    }
 @FXML
 private void initialize(){
        try {
            //Get all User information
            ObservableList<Seancee> empDataS;
            try {
                empDataS = SeanceDAO.findAllSeance();
                 showCours.setItems(empDataS);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(NosCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Populate Employees on TableView
           
        } catch (SQLException e){
            try {
                System.out.println("Error occurred while getting employees information from DB.\n" + e);
                throw e;
            } catch (SQLException ex) {
                Logger.getLogger(NosCoursController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    colMatiere.setCellValueFactory(cellData -> cellData.getValue().getMat().getIntitulePro());
    colFiliere.setCellValueFactory(cellData -> cellData.getValue().getC().getFilierePro());
    colSection.setCellValueFactory(cellData -> cellData.getValue().getC().getSectionPro());
    colDate.setCellValueFactory(cellData ->cellData.getValue().getDatePro());
    colProfesseur.setCellValueFactory(cellData -> cellData.getValue().getProf().getnomProfesseurPro());
    colDuree.setCellValueFactory(cellData -> cellData.getValue().getunedureePro().asObject());
   
 }

}
