package metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ludovic
 */
   public class Etudiantt {
    private StringProperty nom;
    private StringProperty prenom;
    private StringProperty email;
    private IntegerProperty age;
    private Classee classe ;
    
    public Etudiantt(){
       this.nom = new SimpleStringProperty();
       this.prenom = new SimpleStringProperty();
       this.email = new SimpleStringProperty();
       this.age = new SimpleIntegerProperty();
       
       classe = new Classee() ;
        
    }
    public StringProperty getnomPro(){
            return nom;
    }
    public StringProperty getprenomPro(){
        return prenom;
    }
    public StringProperty getemailPro(){
        return email;
       }
     public IntegerProperty getagePro(){
        return age;
       
     }
     public void setnomPro(StringProperty nomEtudiant){
             this.nom = nomEtudiant;
     }
     public void setprenomPro(StringProperty prenomEtudiant){
             this.prenom = prenomEtudiant;
     }
     public void setemailPro(StringProperty emailEtudiant){
            this.email = emailEtudiant;
     }
     public void setagePro(IntegerProperty ageEtudiant){
             this.age = ageEtudiant;
     }

    public Classee getClasse() {
        return classe;
    }

    public void setClasse(Classee classe) {
        this.classe = classe;
    }
     
    
    // setters de base
    public void setnom(String nomEtudiant){
             this.nom.set(nomEtudiant);
     }
     public void setprenom(String prenomEtudiant){
             this.prenom.set(prenomEtudiant);
     }
     public void setemail(String emailEtudiant){
            this.email.set(emailEtudiant);
     }
     public void setage(int ageEtudiant){
             this.age.set(ageEtudiant);
     }
        
     
     // Getters de base
     public String getnom(){
            return nom.get();
    }
    public String getprenom(){
        return prenom.get();
    }
    public String etemailPro(){
        return email.get();
       }
     public int getage(){
        return age.get();
       
     }
     
     
    }

