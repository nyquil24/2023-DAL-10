package org.nequiltaborn.imbibinglush.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "role_name")
    private String name;

    public Role(String name){
        super();
        this.name = name;
    }

}
