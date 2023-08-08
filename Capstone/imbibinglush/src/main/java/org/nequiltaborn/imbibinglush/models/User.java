package org.nequiltaborn.imbibinglush.models;



import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "user_email"))
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "user_fname")
    private String fName;
    @Column(name = "user_lname")
    private String lName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;

}
