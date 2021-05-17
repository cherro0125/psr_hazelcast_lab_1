package pl.psk.hazelcast.client.impl;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;
import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.config.HazelcastConfig;
import pl.psk.hazelcast.model.Book;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ClientImpl implements Client {

    private HazelcastInstance instance;
    private final String MAP_NAME = "books";
    final private static Random r = new Random(System.currentTimeMillis());


    @Override
    public void start() throws UnknownHostException {
        ClientConfig clientConfig = HazelcastConfig.getClientConfig();
        instance = HazelcastClient.newHazelcastClient(clientConfig);
    }

    private IMap<Long, Book> getMap() {
        return instance.getMap(MAP_NAME);
    }

    @Override
    public List<Book> getBooks(Predicate... predicatesArgs) {
        Collection<Book> books;
        if (predicatesArgs.length != 0) {
            books = getMap().values(Predicates.and(predicatesArgs));
        } else {
            books = getMap().values();
        }

        return new LinkedList<>(books);
    }

    @Override
    public Book getBook(Long id) {
        return getMap().get(id);
    }

    @Override
    public void insertBook(Book book) {
        Long id = (long) Math.abs(r.nextInt());
        getMap().put(id, book);
    }

    @Override
    public void deleteBook(Long id) {
        getMap().delete(id);
    }

    @Override
    public void modifyBook(Long id, Book book) {
        getMap().put(id, book);
    }
}
