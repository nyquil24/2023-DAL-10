package org.nequiltaborn.imbibinglush.services.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserLoginDto {

    private String email;
    private String password;
}
