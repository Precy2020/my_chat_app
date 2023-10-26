package org.precious.data.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document("Messages")

public class Message{

    @Id
    private String id;
    private LocalDate dateCreated = LocalDate.now();
    private String body;
    private boolean isSeen;
    private String chatId;
}