package DAO;
    import java.sql.PreparedStatement;
    import java.sql.Connection ;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import metier.Etudiantt;
/**
 *
 * @author Ludovic
 */
public class EtudiantDAO {
    
    public static void insertEtudiant(Etudiantt etud) throws SQLException, ClassNotFoundException{
    // connexion à la base de données
    Connection cnx = Connect.getInstance().getConnection();
    
    // creation de la requete
    String requeteSQL = "INSERT INTO `etudiant`( `Nom`, `Prenom`, `Email`, `age`, `ID_classe`) VALUES (?,?,?,?,? )"; 
    
        PreparedStatement pst = cnx.prepareStatement(requeteSQL);
        
        pst.setString(1, etud.getnom());
        pst.setString(2,etud.getprenom());
        pst.setString(3,etud.etemailPro());
        pst.setInt(4,etud.getage());
        pst.setInt(5,ClasseDAO.GetIdClasse(etud.getClasse().getFiliere(),etud.getClasse().getSection()));
        int i =   pst.executeUpdate();
        
                
    }   
    
    public static ObservableList<Etudiantt> findEtud() throws ClassNotFoundException, SQLException {
        System.out.println("bon");
        ObservableList<Etudiantt> listeN = FXCollections.observableArrayList();
        Connection cnx = Connect.getInstance().getConnection();
        String reqP = "SELECT  `Nom`, `Prenom`, `Email`, `age`, `ID_classe` FROM `etudiant`";
        PreparedStatement pst = cnx.prepareStatement(reqP);
        ResultSet jeu = pst.executeQuery();
        
                while(jeu.next()){
                        Etudiantt nwEtud = new Etudiantt();
                        nwEtud.setnom(jeu.getString("nomEtudiant"));
                        nwEtud.setprenom(jeu.getString("prenomEtudiant"));
                        nwEtud.setemail(jeu.getString("Email"));
                        nwEtud.setage(jeu.getInt("age"));
                        
                        listeN.add(nwEtud);
                }
return listeN;
    
}
}