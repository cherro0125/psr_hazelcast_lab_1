package pl.psk.hazelcast.console.impl;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.Command;
import pl.psk.hazelcast.console.util.ConsoleUtils;
import pl.psk.hazelcast.model.Author;
import pl.psk.hazelcast.model.Book;
import pl.psk.hazelcast.model.Category;

import java.util.Arrays;
import java.util.Date;

public class AddBookCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            Author author = Author.getFromConsole();
            Book book = Book.getFromConsole(author);

            client.insertBook(book);
        }
    }

    @Override
    public String getDescription() {
        return "Add book";
    }
}
