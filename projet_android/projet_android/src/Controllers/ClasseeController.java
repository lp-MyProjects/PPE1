/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.ClasseDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import metier.Classee;

/**
 *
 * @author Ludovic
 */
public class ClasseeController {
    @FXML 
    TextField filiere;
      @FXML 
    TextField section ;
       @FXML 
    TextField annee ;
   private void initialize(){
 
    //   private void 
//          try {
//        ObservableList<Classee> empData = ClasseDAO.findClasse();
////        ComboxAnnee.setItems(empData);
//          filiere.3
//        section.setItems(empData);
//        
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(SeanceeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//
//        StringConverter<Classee> fil = new StringConverter<Classee>() {
//                            @Override
//                            public Classee fromString(String stringF) {
//                            return null;
//                            }
//                            @Override
//                            public String toString(Classee Stringfil) {
//                            return Stringfil.getFiliere();
//                            }
//                            };
//
////        StringConverter<Classee> years = new StringConverter<Classee>(){
////                            @Override
////                            public Classee fromString(String years) {
////                            return null;
////                            }
////                           @Override 
////                            public Classee frormString(String yearsInt){
////                            return yearsInt.geteAnnee();
////                                                                        }
////                            
////                            };
////        StringConverter<Classee> Sec = new StringConverter<Classee>(){
////                            @Override
////                            public Classee fromString(String mySec) {
////                            return null;
////                            }
////                           @Override 
////                            public Classee frormString(String mystrSection){
////                            return mystrSection.getSection();
////    
//                            ComboxAnnee.setConverter(years);
//                            ComboxFiliere.setConverter(fil);
//                            ComboxSection.setConverter(sec);
                            
}
                                    
     

}
