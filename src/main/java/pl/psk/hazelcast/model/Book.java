package pl.psk.hazelcast.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private String name;
    private Date createdAt;
    private List<Category> category;
    private Author author;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
                .append(String.format("Name => %s",this.name))
                .append("\n")
                .append(String.format("Created at => %s",this.createdAt.toString()))
                .append("\n");
        if(category != null && !category.isEmpty()){
            sb.append("Categories: [");
            category.forEach(category ->{
                sb.append(category.toString());
                sb.append(",");
            });
            sb.append("]");
        }

        if (author != null){
            sb.append("\nAuthor:{ ")
                    .append("\n")
                    .append(author.toString())
                    .append("}\n");
        }

        return sb.toString();
    }
}
