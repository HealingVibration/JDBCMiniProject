package Service;

import pl.sda.statment.Person;
import util.JDBCConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public List<Person> metodaDoZwracania() {

        try {
            Connection connection = JDBCConnection.getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");
            List<Person> list = new ArrayList<>();

            while (rs.next()) {
                String kobieta = rs.getString("first_name");

                if (kobieta.equals("Milena")) {
                    System.out.println("Jesteś kobietą");
                    Person person = new Person(2, kobieta, "female");
                    list.add(person);
                    return list;
                }


            }
            return list;
        } catch (
                SQLException trowables) {
            trowables.printStackTrace();
        }
        return null;
    }
}