package org.nequiltaborn.imbibinglush;


import org.junit.jupiter.api.Test;
import org.nequiltaborn.imbibinglush.models.Cordial;
import org.nequiltaborn.imbibinglush.repositories.CordialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CordialRepositoryTests {
    @Autowired
    private CordialRepository repo;


    @Test
    public void testAddNew() {
        Cordial cordial = new Cordial();
        cordial.setCordialName("Triple Sec");
        cordial.setCordialFlavor("Orange");

        repo.save(cordial);

    }

    @Test
    public void testListAll(){
        Iterable<Cordial> cordials = repo.findAll();

        for(Cordial cordial : cordials){
            System.out.println(cordial);
        }
    }

//    @Test
//    public void testUpdate(){
//        Integer cordialId = 1;
//        Optional<Cordial> optionalCordial = repo.findById(cordialId);
//        Cordial cordial = optionalCordial.get();
//        cordial.setCordialFlavor("Remix");
//        repo.save(cordial);
//
//        Cordial updateCordial = repo.findById(cordialId).get();
//
//    }

//    @Test
//    public void testGetCordial() {
//        Integer cordialId = 2;
//        Optional<Cordial> optionalCordial = repo.findById(cordialId);
//        System.out.println(optionalCordial.get());
//    }

    @Test
    public void testDeleteCordial(){
        Integer cordialId = 2;
        repo.deleteById(cordialId);

        Optional<Cordial> optionalCordial = repo.findById(cordialId);
    }


}