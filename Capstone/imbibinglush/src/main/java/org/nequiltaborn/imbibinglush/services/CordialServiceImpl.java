package org.nequiltaborn.imbibinglush.services;

import org.nequiltaborn.imbibinglush.models.Cordial;
import org.nequiltaborn.imbibinglush.repositories.CordialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CordialServiceImpl implements CordialService {

    @Autowired
    private CordialRepository repo;


    @Override
    public List<Cordial> getAllCordials() {
        return repo.findAll();
    }
}
