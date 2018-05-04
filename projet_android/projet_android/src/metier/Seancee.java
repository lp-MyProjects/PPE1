package metier;

import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Ludovic
 */
public class Seancee {
    private ObjectProperty<LocalDate> date;
    private StringProperty description;
    private DoubleProperty uneduree;
    private Matiere mat ;
    private Classee c ;
    private Professeurr prf;
    
    public Seancee (){
        
        this.date =  new SimpleObjectProperty<>();
        this.description= new SimpleStringProperty();
        this.uneduree = new SimpleDoubleProperty();
        this.mat =  new Matiere () ;
        this.c = new  Classee();
        this.prf = new Professeurr();
        
    }

    public StringProperty getdescriptionPro(){
        return description;
    }
    public DoubleProperty getunedureePro(){
        return uneduree;
    }
         public ObjectProperty<LocalDate> getDatePro (){
            return date;
     }
    public void setdescriptionPro(StringProperty descriptionClasse){
        this.description = descriptionClasse;
    }
    public void setdureePro(DoubleProperty unedureePro ){
        this.uneduree = unedureePro;
    }
         public void setDatePro(ObjectProperty<LocalDate>date){
            this.date = date;
     }
    
    // Getters et setters de classe et matiere 
    
        public Professeurr getProf(){
            return prf;
        } 
          
        public void setProf(Professeurr prf){
            this.prf = prf;
        }
        
    public Matiere getMat() {
        return mat;
    }

    public void setMat(Matiere mat) {
        this.mat = mat;
    }

    public Classee getC() {
        return c;
    }

    public void setC(Classee c) {
        this.c = c;
    }
    
  //getters de base
        public LocalDate getdate(){
        return date.get() ;
        }
        
        public String getdescription(){
        return description.get() ;
              }

         public double getduree(){
         return uneduree.get();
              }
// Setters de  base 
         public void setDate(LocalDate date){
            this.date.set(date);
     }
         public void setdescription (String coursDescription){
             this.description.set(coursDescription);
     }
         public void setduree (double uneDuree){
             this.uneduree.set(uneDuree);
     }

    public Matiere getintitule_Mat() {
       return this.mat ;
    }
    public Professeurr getnameProf(){
        return this.prf;
    }

    public void setdate(LocalDate date) {
       this.date.set(date);
    }

    public void setMat(String mat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

