package org.nequiltaborn.imbibinglush.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;


@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
public class Liquor {
    @Id
    @Column(name = "liquor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "liquor_name")
    private String liquorName;
    @Column(name="liquor_type")
    private String liquorType;


    public Liquor(Model model) {
    }
}
