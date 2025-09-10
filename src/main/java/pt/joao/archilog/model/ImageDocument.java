package pt.joao.archilog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "images")
public class ImageDocument { 

    @Id
    private String id;
    private String name;
    private String contentType;
    private byte[] imageData; 

} 