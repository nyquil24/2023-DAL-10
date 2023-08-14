package org.nequiltaborn.imbibinglush.services;

import org.nequiltaborn.imbibinglush.models.Liquor;

import java.util.List;

public interface LiquorService {
    List<Liquor> getAllLiquors();

    void saveLiquor(Liquor liquor);

    Liquor getLiquorById(Long id);

    void deleteEmployeeById(long id);

}
