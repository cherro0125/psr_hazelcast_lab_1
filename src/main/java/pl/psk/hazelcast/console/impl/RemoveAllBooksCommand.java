package pl.psk.hazelcast.console.impl;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.Command;

public class RemoveAllBooksCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            client.deleteAllBooks();
            System.out.println("DELETED ALL RECORDS");
        }
    }

    @Override
    public String getDescription() {
        return "Remove all books";
    }
}
