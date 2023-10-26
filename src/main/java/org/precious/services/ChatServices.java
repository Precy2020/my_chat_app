package org.precious.services;

import org.precious.dtos.request.ChatRequest;
import org.springframework.stereotype.Service;

@Service
public interface ChatServices {

    void createChat(ChatRequest chatRequest);
    Long countChat();


}
