package pl.sda.statment;

import util.JDBCConnection;

import java.sql.*;

public class JDBCCRUDEExample {



    public static void main(String[] args) {
    String updatePerson = "UPDATE person set last_name = ? where id = ? ";

        try {

            Connection connection = JDBCConnection.getConnection();

       //     PreparedStatement preparedStatement = connection.prepareStatement(updatePerson);

   //         preparedStatement.setString(1, "Nirvana");
     //       preparedStatement.setInt(2,4);



            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person");

            ResultSet rs = preparedStatement.executeQuery();
          //  ResultSet rs2 = preparedStatement.executeQuery();
            System.out.println("zauktualizowano ");


            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("first_name");


                System.out.println(name + "   " + id);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
