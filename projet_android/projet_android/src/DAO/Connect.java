package DAO;
import java.sql.Connection; // gère la connection à la base de données
import java.sql.DriverManager; // gère le chargement des pilotes  et créer de nouvelle connection à la BDD et tient à jour les pilotes JDBC
import java.sql.ResultSet; // Les resultats dans la base de données et gère l'accès aux résultats
import java.sql.SQLException; 
import java.sql.Statement; // Classe que l'appliquation utilise pour transmettre des instructions à la base comme pour des requêtes SQL et la fermeture d'un statement ferme tout les resultSet associés 


public class Connect {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String DBNAME = "projet_Android";
    private static final String URL = "jdbc:mysql://localhost/"+DBNAME;
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connect instance;

    private Connect() {
        try {
            Class.forName(DRIVER).newInstance();
            System.out.println("*** Driver loaded. ***");
        }
        catch (ClassNotFoundException e) {
            System.err.println("*** ERROR: Driver " + DRIVER + " non trouvÃ© ***");
        }
        catch (InstantiationException e) {
            System.err.println("*** ERROR: Impossible to create an instance of " + "org.apache.derby.jdbc.ClientDriver");
            System.err.println(e.getMessage());
        }
        catch (IllegalAccessException e) {
            System.err.println("*** ERROR: Impossible to create an instance of " + "org.apache.derby.jdbc.ClientDriver");
            System.err.println(e.getMessage());
        }
    }
    public static Connect getInstance() {
        if (instance == null) {
            instance = new Connect();
        }
        return instance;
    }

    public static String getDBNAME() {
        return DBNAME;
    }

    public Connection getConnection() throws SQLException {
        Connection cx = DriverManager.getConnection(URL, USER, PASSWORD);
        return cx;
    }

    public void close(final Connection cx) {
        if (cx != null) {
            try {
                cx.close();
            }
            catch (SQLException e) {
                // trÃ¨s rare a priori donc pas de throws
                System.err.println("Impossible to close connection");
                System.err.println(e.getMessage());
            }
        }
    }

    public void close(final Statement st) {
        if (st != null) {
            try {
                st.close();
            }
            catch (SQLException e) {
                System.err.println("Impossible to close statement");
                System.err.println(e.getMessage());
            }
        }
    }

    public void close(final ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                System.err.println("Impossible to close resultSet");
                System.err.println(e.getMessage());
            }
        }
    }
}
