package org.precious.services;

import org.precious.data.models.Chat;
import org.precious.data.models.User;
import org.precious.data.repository.UserRepository;
import org.precious.dtos.request.ChatRequest;
import org.precious.dtos.request.RegisterUserRequest;
import org.precious.dtos.response.RegisterUserResponse;
import org.precious.exceptions.AlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.precious.utils.Mapper.map;

@Service
public class UserServicesImpl implements  UserServices{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatServices chatServices;

    @Override
    public RegisterUserResponse registerWith(RegisterUserRequest registerUserRequest) {
        findUser(registerUserRequest);
        return map(userRepository.save(map(registerUserRequest)));
    }

    @Override
    public void createChatFor(ChatRequest createChatRequest) {

    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    private void findUser(RegisterUserRequest registerUserRequest) {
        Optional<User> user = userRepository.findByEmail((registerUserRequest.getUsername()));
        if(user.isPresent()) throw new AlreadyExistException("Username Already Exist");
    }

}
