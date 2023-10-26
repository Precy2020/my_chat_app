package org.precious.dtos.request;

import lombok.Data;
import org.precious.data.models.User;

@Data
public class ChatRequest {

    private String firstUser;
    private String secondUser;
}
