import util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException, ParseException {
        Connection connection = JDBCConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Book");

        List<Book> list = new ArrayList<>();

        ResultSet rs = preparedStatement.executeQuery();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

       Date dateToCompare =  sdf.parse("2021/05/06");
        Date date = sdf.parse("2019/09/09");
        Book book = new Book(2,"Sienkiewicz","Polska","isbn",date, "Ogniem i Mieczem");



        try {

        while(rs.next()){
            Book book2 = new Book(rs.getInt("id"), rs.getString("author"),rs.getString("description"),
                    rs.getString("isbn"), rs.getDate("release_date"),rs.getString("title"));

            System.out.println(book.returnBook(dateToCompare,book, book2));
            System.out.println(book.returnBooksByAuthor("Sienkiewicz",book,book2));


        }


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
