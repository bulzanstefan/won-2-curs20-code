package ro.fasttrackit.curs20;

import java.sql.*;

public class NoSpringConnection {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-rfam-public.ebi.ac.uk:4497/Rfam", "rfamro", "")) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * from clan");

            while(result.next()){
                System.out.print(result.getString("description"));
                System.out.print(":");
                System.out.println(result.getString("author"));
            }
        }
    }
}
