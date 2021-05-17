package pl.psk.hazelcast.console.impl;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.Command;
import pl.psk.hazelcast.console.util.ConsoleUtils;
import pl.psk.hazelcast.model.Book;

public class FindBookByIdCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            System.out.println("Type ID:");
            int value = ConsoleUtils.readConsoleValue();
            Book book = client.getBook((long) value);
            if(book != null){
                System.out.println(String.format("Found book : %s\n",book.toString()));
            }else{
                System.out.println(String.format("Book with ID: %d not found.",value));
            }

        }
    }

    @Override
    public String getDescription() {
        return "Find book by id";
    }
}
