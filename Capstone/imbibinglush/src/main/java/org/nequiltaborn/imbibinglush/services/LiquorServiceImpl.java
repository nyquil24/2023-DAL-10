package org.nequiltaborn.imbibinglush.services;

import org.nequiltaborn.imbibinglush.models.Liquor;
import org.nequiltaborn.imbibinglush.repositories.LiquorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class LiquorServiceImpl implements LiquorService{

    @Autowired
    private LiquorRepository liquorRepository;

    @Override
    public List<Liquor> getAllLiquors() {
        return liquorRepository.findAll();
    }

    @Override
    public void saveLiquor(Liquor liquor) {
        this.liquorRepository.save(liquor);
    }

    @Override
    public Liquor getLiquorById(Long id) {
        Optional<Liquor> optional = liquorRepository.findById(id);
        Liquor liquor = null;
        if(optional.isPresent()){
            liquor = optional.get();
        }else {
            throw new RuntimeException("Employee not found for id :: " + id);
        }
        return liquor;
        }

    @Override
    public void deleteEmployeeById(long id) {
        this.liquorRepository.deleteById(id);
    }


}
