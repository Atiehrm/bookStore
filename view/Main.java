package view;

import model.BookStore;
import service.BookStoreService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static BookStoreService bookStoreService;

    static {
        try {
            bookStoreService = new BookStoreService();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        System.out.println("   |    author   |     ISBN      |    book Title   | published year |    Price    | Sold Number | Sold total Price  | ");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");

        Map<String, List<BookStore>> resultMap = bookStoreService.getAllPerAuthor();
        for (Map.Entry<String, List<BookStore>> entry : resultMap.entrySet()) {
            System.out.print("\t\t"+entry.getKey());
            int checkNewLine = 0;
            for (BookStore bookStore : entry.getValue()){
                if (checkNewLine != 0) {
                    System.out.print("\t\t\t ");
                }
                System.out.println("\t\t"+bookStore.getIsbn() + "\t\t\t" + bookStore.getBookTitle() + "\t\t\t" + bookStore.getPublishedYear()+
                     "\t\t\t"+   bookStore.getPrice() + "\t\t\t"+ bookStore.getSoldNumber()+"\t\t\t\t"+ bookStore.calculateTotalPrice(bookStore) );
                checkNewLine++;}
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
        }
    }
}
