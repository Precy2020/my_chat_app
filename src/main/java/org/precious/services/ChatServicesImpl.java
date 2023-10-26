package org.precious.services;

import org.precious.data.models.Chat;
import org.precious.data.models.User;
import org.precious.data.repository.ChatRepository;
import org.precious.dtos.request.ChatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.precious.utils.Mapper.map;

@Service
public class ChatServicesImpl implements ChatServices{
    @Autowired
    private ChatRepository chatRepository;


    @Override
    public void createChat(ChatRequest chatRequest) {
        Chat chat = new Chat();
        map(chatRequest, chat);
        chatRepository.save(chat);
    }

    @Override
    public Long countChat() {
        return chatRepository.count();
    }





}
