package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateUser {
    public static void main(String[] args) {
        //Creates a SessionFactory object using the Hibernate configuration.
        /*The Configuration class is used to configure Hibernate, and the configure() method
         loads the configuration from a default location.*/
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    /*This line opens a new Session object from the SessionFactory.
    The Session represents a single-unit-of-work with the DB and provides methods to perform DB operations
     */
    Session session = factory.openSession();
    /*this line starts a new DB transaction withing the current session. A transaction is a logical
    unit of work that consists of one or more DB operations(such as inserts, updates, or deletes)
     The beginTransaction() method returns a Transaction object taht allows you to control and manage the
     transaction.By using the Transaction object, you can commit the transaction to make the changes
     permanent or roll it back to discard the changes*/
    Transaction t = session.beginTransaction();


    User uone = new User();
    uone.setEmail("haseeb@gmail.com");
    uone.setFullname("Moh Haseeb");
    uone.setPassword("has123");
    uone.setSalary(2000.69);
    uone.setAge(20);
    uone.setCity("NYC");

    User uTwo = new User();
    uTwo.setEmail("James@gmail.com");
    uTwo.setFullname("James Santana");
    uTwo.setPassword("James123");
    uTwo.setSalary(2060.69);
    uTwo.setAge(25);
    uTwo.setCity("Dallas");

    User uThree = new User();
    uThree.setEmail("Shahparan@gmail.com");
    uThree.setFullname("AH Shahparan");
    uThree.setPassword("Shahparan123");
    uThree.setSalary(3060.69);
    uThree.setAge(30);
    uThree.setCity("Chicago");

    /*======= We can pass value/data by using constructor =======*/
    User uFour = new User("Christ","christ@gamil.com", "147852", 35, 35000.3,"NJ");
    User uFive = new User("Sid","Sid","s258",29,4000.36,"LA");
    //Integer userid = null

        /* These lines persist(saves) the objects into the DB using the persist() method. The persist()
        * method is used to make a transient(newly created) object persistent, meaning it will be saved
        * in the DB  */
    session.persist(uone);
    session.persist(uTwo);
    session.persist(uThree);
    session.persist(uFour);
    session.persist(uFive);
}
}