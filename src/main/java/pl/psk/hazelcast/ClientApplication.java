package pl.psk.hazelcast;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.client.impl.ClientImpl;
import pl.psk.hazelcast.model.Author;
import pl.psk.hazelcast.model.Book;
import pl.psk.hazelcast.model.Category;

import java.net.UnknownHostException;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Arrays;

public class ClientApplication {
    public static void main(String[] args) throws UnknownHostException {
        Client client = new ClientImpl();
        client.start();

        Author author = new Author("Adolf","Hitler",33);
        Book book = new Book("Main kampff", new Date(), Arrays.asList(Category.MANGA,Category.ADVENTURE,Category.DRAMAT),author);

        client.insertBook(book);

        client.getBooks().forEach(System.out::println);


    }
}
