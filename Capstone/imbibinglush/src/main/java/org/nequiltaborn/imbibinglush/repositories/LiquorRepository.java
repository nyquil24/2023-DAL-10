package org.nequiltaborn.imbibinglush.repositories;

import org.nequiltaborn.imbibinglush.models.Liquor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquorRepository extends JpaRepository<Liquor, Long> {
}
