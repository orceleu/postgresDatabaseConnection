

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {



    //connect to postgres
    public static void main(String[] args) throws SQLException, InterruptedException {

        String pasword;
        System.out.println("enter password!");
        Scanner input = new Scanner(System.in);
        pasword = input.nextLine().toString();
        if (pasword != null) {
            ConnectionUtil db = new ConnectionUtil();
            Connection conn = db.connect_to_db("film", "postgres", pasword);
             //db.createTable(conn, "recovery");
            //db.insert_row(conn,4,1356.23);
            db.showDataFilm(conn,"acteurs");

        }
    }
}