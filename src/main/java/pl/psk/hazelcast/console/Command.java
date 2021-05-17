package pl.psk.hazelcast.console;

public interface Command {
    void execute(Object... args);
    String getDescription();
}
