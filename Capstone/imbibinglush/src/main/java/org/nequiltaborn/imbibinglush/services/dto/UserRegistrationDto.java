package org.nequiltaborn.imbibinglush.services.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.nequiltaborn.imbibinglush.models.Role;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserRegistrationDto {

    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private List<Role> roles;


}
