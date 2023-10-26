package org.precious.dtos.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterUserResponse {

    private String username;
    private String dateCreated;
}
