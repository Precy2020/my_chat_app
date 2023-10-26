package org.precious.services;

import org.precious.data.models.User;
import org.precious.dtos.request.ChatRequest;
import org.precious.dtos.request.RegisterUserRequest;
import org.precious.dtos.response.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {


    RegisterUserResponse registerWith(RegisterUserRequest registerUserRequest);
   void  createChatFor(ChatRequest createChatRequest);

   User findByEmail(String email);

}
