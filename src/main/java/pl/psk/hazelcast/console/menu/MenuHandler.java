package pl.psk.hazelcast.console.menu;

import pl.psk.hazelcast.client.Client;
import pl.psk.hazelcast.console.CommandExecutor;
import pl.psk.hazelcast.console.util.ConsoleUtils;

import java.util.Scanner;

public class MenuHandler {

    private final CommandExecutor commandExecutor;
    private final Scanner scanner = new Scanner(System.in);
    private Client client;
    private static boolean showMenu = true;

    public MenuHandler(Client client) {
        this.commandExecutor = new CommandExecutor();
        this.client = client;
    }

    private void showMenuText(){
        System.out.println(commandExecutor.getMenuText());
        System.out.println("OPTION: ");
    }

    private void handleOption(int option,Object... args){
        commandExecutor.executeCommand((long) option,args);
    }

    public void start(){
        while(showMenu){
            showMenuText();
            handleOption(ConsoleUtils.readConsoleValue(),client);
        }

    }

    public static void exitMenu(){
        showMenu = false;
    }


}
