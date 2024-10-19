package org.cubewhy.skidhomework.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(value = "book")
public class Book {
    @Id
    private String id;

    private String title;
    @DBRef
    private User uploader;
    private String isbn; // used to search books

    private LocalDateTime edition; // 版次 只需要精确到月
}
