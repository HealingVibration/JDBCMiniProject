

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book {
    int id;
    String author;
    String description;
    String isbn;
    Date release_date;
    String title;


    public Book(int id, String author, String description, String isbn, Date release_date, String title) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.isbn = isbn;
        this.release_date = release_date;
        this.title = title;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<Book> returnBook(Date date, Book... books) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMM/dd");
        List<Book> list = new ArrayList<>();

        for (Book book : books) {
            if (book.release_date.getTime() < date.getTime()) {
                list.add(book);
            }
        }
        return list;
    }

    public List<Book> returnBooksByAuthor(String author, Book... books) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.author.equals(author)) {
                list.add(book);
            }
        }

        return list;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                ", release_date=" + release_date +
                ", title='" + title + '\'' +
                '}';
    }


}
