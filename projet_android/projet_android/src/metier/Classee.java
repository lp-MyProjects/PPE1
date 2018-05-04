package metier;

//Classe suivi par l'étudiant, sa section ainsi que son année d'étude

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Classee {
   private StringProperty filiere;
   private StringProperty section;
   private IntegerProperty annee;
   public Classee(){
        
        this.filiere = new SimpleStringProperty();
        this.section = new SimpleStringProperty();
        this.annee = new SimpleIntegerProperty();
        }
    // get et set FXML
    public StringProperty getFilierePro(){
        return filiere;
    }
    public StringProperty getSectionPro(){
        return section;
    }
   public IntegerProperty geteAnnee(){
       return annee;
   }
  public void setfilierePro (StringProperty efiliere){
      this.filiere = efiliere;   
   }
   public void setsectionPro (StringProperty eSection){
      this.section = eSection;
}
   public void setannePro (IntegerProperty eAnnee){
      this.annee = eAnnee;
}
    // get set de base
    public String getFiliere(){
        return filiere.get();
    }
    public String getSection(){
        return section.get();
    }
   public int getAnnee(){
       return annee.get();
   }
  public void setfiliere (String efiliere){
      this.filiere.set(efiliere);  
   }
   public void setsection (String eSection){
      this.section.set(eSection);
}
   public void setannee (int eAnnee){
      this.annee.set(eAnnee);
}
    @Override
    public String toString() {
        return "Classee{" + "filiere=" + filiere + ", section=" + section + ", annee=" + annee + '}';
    }

    public void setSection(String section) {
   this.section.set(section);
    }
   
    
    
}