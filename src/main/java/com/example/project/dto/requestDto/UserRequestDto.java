package com.example.project.dto.requestDto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRequestDto {

    @NotNull
    @Size(min = 8, message = "Correo debe tener al memnoos 8 caracteres")
    @Email
    private String email;

    @NotNull
    @Size(min = 8, message = "Contraseña debe tener al menos 8 caracteres")
    private String password;

}
