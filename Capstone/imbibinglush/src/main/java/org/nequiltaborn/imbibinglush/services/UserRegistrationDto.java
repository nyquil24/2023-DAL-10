package org.nequiltaborn.imbibinglush.services;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserRegistrationDto {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;



}
