package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import metier.Matiere;
import metier.Professeurr;


public class ProfesseurDAO {
    
    public static void insertProfesseur(Professeurr prof) throws SQLException, ClassNotFoundException{
    // connexion à la base de données
    Connection cnx = Connect.getInstance().getConnection();
    
    // creation de la requete
    String requeteSQL = "INSERT INTO Professeur(  nomProfesseur, emailProfesseur, ID_Matiere) VALUES (?,?,?)"; 
    
        PreparedStatement pst = cnx.prepareStatement(requeteSQL);
        
       pst.setString(1,prof.getnomProfesseur());
        pst.setString(2,prof.getemail());
        pst.setInt(3,MatiereDAO.getID_MATIERE(prof.getMatiere().getIntitule()));  
        int idProf =   pst.executeUpdate(); 
        
    }
    
    
    
    
    
    public  static ObservableList<Professeurr> findProf() throws ClassNotFoundException, SQLException {
    System.out.println("bon");
        ObservableList<Professeurr> listeN = FXCollections.observableArrayList();
        Connection cnx = Connect.getInstance().getConnection();
        String reqP = "select nomProfesseur from professeur";
        PreparedStatement pst = cnx.prepareStatement(reqP);
        ResultSet jeu = pst.executeQuery();
        
                while(jeu.next()){
                        Professeurr nameTeacher = new Professeurr();
                        nameTeacher.setnomProfesseur(jeu.getString("nomProfesseur"));

                        listeN.add(nameTeacher);
                }
                        return listeN;
}
    
    public static Professeurr findProfId(int nunu ) throws ClassNotFoundException, SQLException{
       Professeurr findProfID = new Professeurr();
       Connection cnx = Connect.getInstance().getConnection();
       String reqP = "SELECT * FROM professeur where ID_Professeur = ?";
       PreparedStatement pst = cnx.prepareStatement(reqP);
       pst.setInt(1, nunu);
       ResultSet jeu = pst.executeQuery();
       while(jeu.next()){
           
          findProfID.setnomProfesseur(jeu.getString("nomProfesseur"));
                       
       }
       return findProfID;
    
    
    }
   public static int getID_Professeur (String iPrf ) throws SQLException, ClassNotFoundException{
      int id = 0 ;
      Connection cnx = Connect.getInstance().getConnection();
      String requeteSQL = "SELECT ID_Professeur FROM professeur WHERE nomProfesseur = ?";
      PreparedStatement pst =  cnx.prepareStatement(requeteSQL);
      pst.setString(1, iPrf);
      
      ResultSet jeu = pst.executeQuery();
      while(jeu.next()){
      id = jeu.getInt("ID_Professeur");
      
      }
     
      return id;
}
}
