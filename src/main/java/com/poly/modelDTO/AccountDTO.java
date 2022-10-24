package com.poly.modelDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
//    @NotNull
    @NotBlank
    private String username;
    
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String fullname;
    @NotNull
    @NotBlank
    @Email
    private String email;
//    @NotEmpty
    private String photo;
    private boolean role;
    
}
