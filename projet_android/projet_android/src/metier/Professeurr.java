package metier;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Ludovic
 */
public class Professeurr {
    private IntegerProperty id ;
    private StringProperty nomProfesseur;
    private StringProperty email;
    private Matiere matiere ;
    
    //constructeurs de ma class professeur
    public Professeurr(){
        this.id = new SimpleIntegerProperty();
        this.nomProfesseur = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        matiere = new Matiere() ;
        
    }
    //getters de ma class professeur
     public StringProperty getnomProfesseurPro(){
         return nomProfesseur;
     }
     public StringProperty getemailPro(){
         return email;
     }
     
      public String getnomProfesseur(){
         return nomProfesseur.get();
     }
     public String getemail(){
         return email.get();
     }
     public IntegerProperty getidPro(){
         return id;
     }
     //Setters de ma class professeur
     public void setnomProfesseurPro(StringProperty myProfesseur){
             this.nomProfesseur = myProfesseur;
     }
     public void setemailPro(StringProperty emailProfesseur){
             this.email = emailProfesseur;
     }
      public void setnomProfesseur(String myProfesseur){
             this.nomProfesseur.set(myProfesseur);
     }
     public void setemail(String emailProfesseur){
             this.email.set(emailProfesseur);
     }
     public void setid(IntegerProperty idProf){
         this.id = idProf;
     }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "Professeurr{" + "id=" + id + ", nomProfesseur=" + nomProfesseur + ", email=" + email + ", matiere=" + matiere + '}';
    }
      
}
