package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

@ToString

public class BookStore implements Comparable<BookStore> {
    private int id;
    private String bookTitle;
    private String isbn;
    private String author;
    private int publishedYear;
    private long price;
    private int soldNumber;

    public BookStore(int id, String bookTitle, String isbn, String author, int publishedYear, long price, int soldNumber) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.isbn = isbn;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.soldNumber = soldNumber;
    }


    @Override
    public int compareTo(BookStore o) {
        return o.getPublishedYear() - this.getPublishedYear();
    }

    public Long calculateTotalPrice(BookStore bookStore) {
        return bookStore.getPrice() * bookStore.getSoldNumber();
    }
}
