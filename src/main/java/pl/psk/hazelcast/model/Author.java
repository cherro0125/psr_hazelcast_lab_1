package pl.psk.hazelcast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {
    private String name;
    private String surname;
    private Integer age;

    @Override
    public String toString() {
        return new StringBuilder()
                .append(String.format("Name => %s",this.name))
                .append("\n")
                .append(String.format("Surname => %s",this.surname))
                .append("\n")
                .append(String.format("Age => %d",this.age))
                .append("\n")
                .toString();
    }
}
