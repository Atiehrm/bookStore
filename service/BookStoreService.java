package service;

import databaseaccess.BookStoreDao;
import model.BookStore;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class BookStoreService {
    private static BookStoreDao bookStoreDao;

    public BookStoreService() throws SQLException, ClassNotFoundException {
        bookStoreDao = new BookStoreDao();
    }

    public Map<String, List<BookStore>> getAllPerAuthor() throws SQLException {
        List<BookStore> bookList = bookStoreDao.getAll();
        LinkedHashMap<String, List<BookStore>> sortedBookMap = new LinkedHashMap<>();
        bookList.stream().collect(Collectors.groupingBy(BookStore::getAuthor))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).stream()
                .forEachOrdered(x -> sortedBookMap.put((x.getKey()), x.getValue().stream().sorted((BookStore::compareTo))
                        .collect(Collectors.toList())));

        return sortedBookMap;


    }

  /*  public Map<Integer, List<BookStore>> getPerYear() throws SQLException {
        LinkedHashMap<Integer, List<BookStore>> sortMapPerPublishedYear = new LinkedHashMap<>();

        getAllPerAuthor().entrySet().stream().forEach((k) -> k.getValue().stream().collect(Collectors.groupingBy(BookStore::getPublishedYear))
                .entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()).stream().forEachOrdered(
                        z -> sortMapPerPublishedYear.put(z.getKey(), z.getValue())));

        return sortMapPerPublishedYear;
    }*/
}