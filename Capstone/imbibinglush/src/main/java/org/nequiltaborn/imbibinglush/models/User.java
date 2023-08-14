package org.nequiltaborn.imbibinglush.models;



import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Data
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "user_email"))
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_fname")
    private String fName;
    @Column(name = "user_lname")
    private String lName;
    @Column(name = "user_email")
    private String email;
    @Column(name = "user_password")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles")
    @Column(name = "user_role")
    private List<Role> roles = new ArrayList<>();

    public User(String firstName, String lastName, String email, String password, List<Role> roles) {
        super();
        this.fName = firstName;
        this.lName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
