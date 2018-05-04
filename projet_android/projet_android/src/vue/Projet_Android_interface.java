package vue;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Ludovic
 */
public class Projet_Android_interface extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      
        try {
            FXMLLoader acc = new FXMLLoader() ;
            acc.setLocation(Projet_Android_interface.class.getClassLoader().getResource("interface/Seance.fxml"));
            AnchorPane root = (AnchorPane)acc.load();
            Scene scene = new Scene(root, 300, 500);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        }
        
        catch (IOException ex) {
            Logger.getLogger(Projet_Android_interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
    }
    
}
