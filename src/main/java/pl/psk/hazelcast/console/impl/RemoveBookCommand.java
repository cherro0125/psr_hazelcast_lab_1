package pl.psk.hazelcast.console.impl;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.Command;
import pl.psk.hazelcast.console.util.ConsoleUtils;

public class RemoveBookCommand implements Command {
    @Override
    public void execute(Object... args) {
        if(args.length != 0 && args[0] instanceof Client){
            Client client = (Client) args[0];
            System.out.println("Type ID to remove:");
            int value = ConsoleUtils.readConsoleValue();
            client.deleteBook((long) value);
            System.out.println(String.format("DELETED RECORD WITH ID: %d",value));
        }
    }

    @Override
    public String getDescription() {
        return "Remove book";
    }
}
