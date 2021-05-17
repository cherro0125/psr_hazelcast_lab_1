package pl.psk.hazelcast.console.impl;

import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;
import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.Command;
import pl.psk.hazelcast.console.util.ConsoleUtils;
import pl.psk.hazelcast.model.Author;
import pl.psk.hazelcast.model.Book;

public class AdvanceSearchCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            System.out.println("Type book name:");
            String name = ConsoleUtils.readConsoleString();
            Predicate<?,?> namePredicate = Predicates.equal( "name",name);
            client.getBooks(namePredicate).forEach(book -> {
                System.out.printf("\nID: %d {\n%s\n}\n%n",book.getId(),book.toString());
            });
        }
    }

    @Override
    public String getDescription() {
        return "ADVANCE SEARCH BOOK";
    }
}
