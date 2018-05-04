/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;  
import java.sql.Connection ;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Professeurr;

import metier.Seancee;
/**
 *
 * @author Ludovic
 */
public class SeanceDAO {
    
   public static void insertSeance(Seancee seance) throws SQLException, ClassNotFoundException{
    // connexion à la base de données
    Connection cnx = Connect.getInstance().getConnection();
    
    // creation de la requete
    String requeteSQL = "INSERT INTO seance(`uneDate`, `coursDescription`, `uneDuree`, `ID_classe`, `ID_Matiere`,`ID_Professeur`) VALUES (?,?,?,?,?,?)"; 
    
        PreparedStatement pst = cnx.prepareStatement(requeteSQL);
        
        pst.setDate(1, Date.valueOf(seance.getdate()));
        pst.setString(2,seance.getdescription());
        pst.setDouble(3,seance.getduree());
        pst.setInt(4,ClasseDAO.GetIdClasse(seance.getC().getFiliere(), seance.getC().getSection()));
        pst.setInt(5, MatiereDAO.getID_MATIERE(seance.getintitule_Mat().getIntitule()));
        pst.setInt(6, ProfesseurDAO.getID_Professeur(seance.getnameProf().getnomProfesseur()));
        
        int i =   pst.executeUpdate();
}
public static ObservableList<Seancee> findAllSeance() throws ClassNotFoundException, SQLException{
       ObservableList<Seancee> listeN = FXCollections.observableArrayList();
       Connection cnx = Connect.getInstance().getConnection();
       String reqSe= "select * from Seance";
       PreparedStatement pst = cnx.prepareStatement(reqSe);
       ResultSet jeu = pst.executeQuery();
       while(jeu.next()){
          Seancee Seance1 = new Seancee();
          Seance1.setdescription(jeu.getString("coursDescription"));
          Seance1.setduree(jeu.getDouble("uneDuree"));
          String date = String.valueOf(jeu.getDate("uneDate"));
          Seance1.setDate(LocalDate.parse(date));
          Seance1.setC(ClasseDAO.findClasseId(jeu.getInt("ID_classe")));
          Seance1.setMat(MatiereDAO.findMatiereId(jeu.getInt("ID_Matiere")));
          Seance1.setProf(ProfesseurDAO.findProfId(jeu.getInt("ID_Professeur")));
   

                  
                    listeN.add(Seance1);
       }
       return listeN;
   }

}  
