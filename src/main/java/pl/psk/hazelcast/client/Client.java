package pl.psk.hazelcast.client;

import pl.psk.hazelcast.model.Book;

import java.net.UnknownHostException;
import java.util.List;
import com.hazelcast.query.Predicate;

public interface Client {
    void start() throws UnknownHostException;
    List<Book> getBooks(Predicate... predicatesArgs);
    Book getBook(Long id);
    void insertBook(Book book);
    void deleteBook(Long id);
    void deleteAllBooks();
    void modifyBook(Long id, Book book);
}
