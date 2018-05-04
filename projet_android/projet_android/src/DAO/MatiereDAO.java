/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.Connection ;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Matiere;

    
public class MatiereDAO {

   static int getID_MATIERE (String intit) throws SQLException, ClassNotFoundException{
      int id = 0 ;
      Connection cnx = Connect.getInstance().getConnection();
      String requeteSQL = "SELECT ID_Matiere FROM `matiere` WHERE intitule_Mat = ?";
      PreparedStatement pst =  cnx.prepareStatement(requeteSQL);
      pst.setString(1, intit);
      
      ResultSet jeu = pst.executeQuery();
      while(jeu.next()){
      id = jeu.getInt("ID_Matiere");
      
      }
     
      return id;
  }

  
   

public  static ObservableList<Matiere> findMatiere() throws ClassNotFoundException, SQLException {
    System.out.println("bon");
        ObservableList<Matiere> listeN = FXCollections.observableArrayList();
        Connection cnx = Connect.getInstance().getConnection();
        String req = "select intitule_mat from Matiere";
        PreparedStatement pst = cnx.prepareStatement(req);
        ResultSet jeu = pst.executeQuery();
        
                while(jeu.next()){
                        Matiere mat = new Matiere();
                        mat.setIntitule(jeu.getString("intitule_Mat"));
                        
                        listeN.add(mat);
                }
return listeN;
}

   public static Matiere findMatiereId(int id ) throws ClassNotFoundException, SQLException{
       Matiere MatiereID = new Matiere();
       Connection cnx = Connect.getInstance().getConnection();
       String reqFM = "select * from Matiere where ID_Matiere = ?";
       PreparedStatement pst = cnx.prepareStatement(reqFM);
       pst.setInt(1, id);
       ResultSet jeu = pst.executeQuery();
       while(jeu.next()){
          
         MatiereID.setIntitule(jeu.getString("Intitule_Mat"));
         
                   
       }
       return MatiereID;
}
}