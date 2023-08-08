package org.nequiltaborn.imbibinglush.repositories;


import org.nequiltaborn.imbibinglush.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*Establishes a conneciton to DB using the Jpa Interface  */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
