package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Classee;
/**
 *
 * @author Ludovic
 */
public class ClasseDAO {
    

   public static int GetIdClasse(String nomF, String nomSec) throws ClassNotFoundException, SQLException
     {
         
         int i = 0;
         Connection cnx = Connect.getInstance().getConnection();

         String req = "SELECT ID_classe FROM classe where Filiere= ?  and Section= ?" ;
       
         PreparedStatement pst = cnx.prepareStatement(req);
         pst.setString (1, nomF);
         pst.setString(2, nomSec);

         ResultSet jeu = pst.executeQuery();
         while(jeu.next())
         {
             i = jeu.getInt("ID_classe");
             
        
         }
          return i;
         
     }
   public static ObservableList<Classee> findClasse() throws ClassNotFoundException, SQLException{
       ObservableList<Classee> listeN = FXCollections.observableArrayList();
       Connection cnx = Connect.getInstance().getConnection();
       String reqC = "select * from classe";
       PreparedStatement pst = cnx.prepareStatement(reqC);
       ResultSet jeu = pst.executeQuery();
       while(jeu.next()){
          Classee classe1 = new Classee();
          classe1.setannee(jeu.getInt("annee"));
          classe1.setfiliere(jeu.getString("Filiere"));
          classe1.setsection(jeu.getString("Section"));
          
                    listeN.add(classe1);
       }
       return listeN;
   }

   public static Classee findClasseId(int id ) throws ClassNotFoundException, SQLException{
       Classee classe1= new Classee();
       Connection cnx = Connect.getInstance().getConnection();
       String reqC = "select * from classe where ID_classe = ?";
       PreparedStatement pst = cnx.prepareStatement(reqC);
       pst.setInt(1, id);
       ResultSet jeu = pst.executeQuery();
       while(jeu.next()){
          
          classe1.setannee(jeu.getInt("annee"));
          classe1.setfiliere(jeu.getString("Filiere"));
          classe1.setsection(jeu.getString("Section"));
          
                   
       }
       return classe1; 
   }
}
