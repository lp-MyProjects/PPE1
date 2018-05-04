package metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author Ludovic
 */
public class Matiere {

    StringProperty intitule ;

    public Matiere() {
        this.intitule = new SimpleStringProperty();
    }

  public StringProperty getIntitulePro() {
        return intitule ;
    }
   public void setIntitulePro(StringProperty string) {
            this.intitule = string;
    }

    public String getIntitule() {
        return intitule.get();
    }

    public void setIntitule(String string) {
            this.intitule.set(string);
    }
    
   @Override
    public String toString() {
        return this.getIntitule();
    }
}
