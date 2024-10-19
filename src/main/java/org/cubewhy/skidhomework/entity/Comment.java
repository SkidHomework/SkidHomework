package org.cubewhy.skidhomework.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("comment")
public class Comment {
    @Id
    private String id;

    private String content;
    @DBRef
    private User author;
    @DBRef
    private Post post;
    @DBRef
    @Builder.Default
    private Comment parent = null;
}
