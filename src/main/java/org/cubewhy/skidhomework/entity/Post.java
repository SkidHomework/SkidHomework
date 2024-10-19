package org.cubewhy.skidhomework.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "post")
public class Post {
    @Id
    private String id;

    private String title;
    private String content;

    @DBRef
    private User author;
}
