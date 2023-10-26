package org.precious.utils;

import org.precious.data.models.Chat;
import org.precious.data.models.User;
import org.precious.dtos.request.ChatRequest;
import org.precious.dtos.request.RegisterUserRequest;
import org.precious.dtos.response.RegisterUserResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setEmail(registerUserRequest.getUsername());
        user.setPassword(registerUserRequest.getPassword());
        return user;
    }

    public static RegisterUserResponse map(User user){
        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setUsername(user.getEmail());
        registerUserResponse.setDateCreated((DateTimeFormatter.ofPattern("EEEE dd/MMM/yyyy HH:mm:ss a").format(LocalDateTime.now())));
        return registerUserResponse;
    }

    public static void map(ChatRequest chatRequest, Chat chat){
        chat.setChatName(chatRequest.getFirstUser() + " " +  chatRequest.getSecondUser());
        List<String> createdUser = new ArrayList<>();
        createdUser.add(chatRequest.getFirstUser());
        createdUser.add(chatRequest.getSecondUser());
        chat.setUsers(createdUser);
    }
}
