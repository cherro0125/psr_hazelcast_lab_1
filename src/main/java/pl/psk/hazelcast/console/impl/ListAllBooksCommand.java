package pl.psk.hazelcast.console.impl;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.Command;

import java.util.Arrays;

public class ListAllBooksCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            client.getBooks().forEach(book -> {
                System.out.printf("\nID: %d {\n%s\n}\n%n",book.getId(),book.toString());
            });
        }
    }

    @Override
    public String getDescription() {
        return "Show all books";
    }
}
