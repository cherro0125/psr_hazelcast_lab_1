package pl.psk.hazelcast.console.util;

import java.util.Scanner;

public class ConsoleUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static int readConsoleValue() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String readConsoleString(){
        return scanner.nextLine();
    }
}
