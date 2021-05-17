package pl.psk.hazelcast;

import pl.psk.hazelcast.server.HazelcastServer;

import java.net.UnknownHostException;

public class ServerApplication {
    public static void main(String[] args) throws UnknownHostException {
        HazelcastServer.start();
        System.out.println("Hazelcast Server started...");
    }
}
