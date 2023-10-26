package org.precious.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.precious.data.models.User;
import org.precious.data.repository.UserRepository;
import org.precious.dtos.request.ChatRequest;
import org.precious.dtos.request.RegisterUserRequest;
import org.precious.exceptions.AlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServicesTest {


    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatServices chatServices;

    @BeforeEach
    public void deleteBeforeEachTest(){
        userRepository.deleteAll();
    }

    @Test
    public void testThatUserCanRegister(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Username");
        registerUserRequest.setPassword("Password");
        userServices.registerWith(registerUserRequest);

        assertThat(userRepository.count(), is(1L));
    }

    @Test
    public void testThatUserIsUnique(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Username");
        registerUserRequest.setPassword("Password");
        userServices.registerWith(registerUserRequest);

        RegisterUserRequest precious = new RegisterUserRequest();
        precious.setUsername("Username");
        precious.setPassword("Password");
        assertThrows(AlreadyExistException.class, () -> userServices.registerWith(precious));
    }

    @Test
    public void testChatCreate(){
        ChatRequest createChatRequest = new ChatRequest();
        User user = new User();
        user.setEmail("Precious");
        user.setPassword("password");

        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername(user.getEmail());
        registerUserRequest.setPassword(user.getPassword());
        userServices.registerWith(registerUserRequest);

        User user1 = new User();
        user1.setEmail("Abike");
        user1.setPassword("password");

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setUsername(user1.getEmail());
        registerUserRequest1.setPassword(user1.getPassword());
        userServices.registerWith(registerUserRequest1);


        createChatRequest.setFirstUser(String.valueOf(user));
        createChatRequest.setSecondUser(String.valueOf(user1));

        userServices.createChatFor(createChatRequest);
        assertThat(chatServices.countChat(), is(1L));

    }
}