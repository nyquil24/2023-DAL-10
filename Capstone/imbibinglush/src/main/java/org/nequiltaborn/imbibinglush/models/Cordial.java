package org.nequiltaborn.imbibinglush.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Cordial {
    @Id
    @Column(name = "cordial_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cordial_name")
    private String cordialName;
    @Column(name = "cordial_flavor")
    private String cordialFlavor;

}
