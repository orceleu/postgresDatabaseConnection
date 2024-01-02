import java.sql.*;


public class ConnectionUtil {

    public Connection connect_to_db(String dbname, String user, String pass) {

        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
    public void createTable(Connection conn, String recovery) {

        Statement statement;
        try {
            String query = "create table " + recovery + "(id SERIAL PRIMARY KEY NOT NULL, balance numeric(10, 2) default 0, social_security int4 NOT NULL UNIQUE);";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("please enter your social security number");

        } catch (Exception e) {
            System.out.println("entering db information");
            System.out.println("please enter your social security number **1 to exit program**");
        }
    }


    public void insert_row(Connection conn, int socials, double transfer) {
        Statement statement;
        try {
            String query = "INSERT INTO recovery(balance, social_security) VALUES (" + transfer + "," + socials + ");";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("row inserted");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void balance(Connection conn, String recovery) throws SQLException {
        Statement statement;
        try {
            String query = "SELECT * FROM " + recovery + ";";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("id");
                String privatebalances = result.getString("balance");
                String socialsecurity = result.getString("social_security");

                System.out.printf("%d -bal %s -ss %s\n", id, privatebalances, socialsecurity);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void showDataFilm(Connection conn, String table) throws SQLException {
        Statement statement;
        try {
            String query = "SELECT * FROM " + table + ";";
            statement = conn.createStatement();

            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                int id = result.getInt("acteur_id");
                String nom = result.getString("nom");
                String prenom = result.getString("prenom");
                String civilite = result.getString("civilite");
                String date_de_naissance = result.getString("civilite");

                System.out.printf("%s nom: %s prenom: %s civilite: %s date_de_naissance: %s\n", id, nom, prenom,civilite,date_de_naissance);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}