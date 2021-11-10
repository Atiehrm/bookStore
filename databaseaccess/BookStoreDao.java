package databaseaccess;

import model.BookStore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookStoreDao {

    private final Connection connection;

    public BookStoreDao() throws SQLException, ClassNotFoundException {
        this.connection = DataAccess.getConnection();
    }

    public List<BookStore> getAll() throws SQLException {
        List<BookStore> bookStoreList = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement("select * from book_store");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String bookTitle = resultSet.getString("book_title");
            String isbn = resultSet.getString("isbn");
            String author = resultSet.getString("author");
            int publishedYear = resultSet.getInt("published_year");
            long price = resultSet.getLong("price");
            int soldNumber = resultSet.getInt("sold_number");
            BookStore bookStore = new BookStore(id,bookTitle,isbn,author,publishedYear,price,soldNumber);
            bookStoreList.add(bookStore);
        }
        return bookStoreList;
    }
}
