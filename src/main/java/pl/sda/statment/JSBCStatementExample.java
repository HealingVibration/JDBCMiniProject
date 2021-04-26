package pl.sda.statment;

import Service.PersonService;
import util.JDBCConnection;

import javax.swing.text.html.HTMLDocument;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class JSBCStatementExample {





    public static void main(String[] args) {
        PersonService personService = new PersonService();

        personService.metodaDoZwracania();

        try {
            Connection connection = JDBCConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM person");


            while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("first_name");


                System.out.println(name + "   " + id);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
