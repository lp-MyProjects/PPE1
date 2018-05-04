package vue;

import DAO.EtudiantDAO;
import DAO.MatiereDAO;
import DAO.ProfesseurDAO;
import DAO.SeanceDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import metier.Classee;
import metier.Etudiantt;
import metier.Matiere;
import metier.Professeurr;
import metier.Seancee;

public class Projet_android {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        try {
            /*TODO code application logic here
            Classee classe1 = new Classee("SIO", "SLAM", 2017);
            Etudiantt etud1 = new Etudiantt("nomEtudiant", "prenomEtudiant", "emailEtudiant",18, classe1);
            Matiere mat = new Matiere("Informatique");
            Professeurr prof1 = new Professeurr("Guerfi", "guerfi@test.fr" , mat);
            LocalDate de = LocalDate.of(2017, Month.MARCH, 5);
                    
            Seancee seance1 = new Seancee(de, "String coursDescription", 3.2, mat , classe1);
           
            // EtudiantDAO.insertEtudiant(etud1);
            SeanceDAO.insertSeance(seance1);
            } catch (SQLException ex) {
            Logger.getLogger(Projet_android.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
            Logger.getLogger(Projet_android.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            ObservableList<Matiere> empData =  MatiereDAO.findMatiere();
            System.out.println(empData);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Projet_android.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Projet_android.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        

    }
}
