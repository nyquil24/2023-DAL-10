package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class  CreateUserTable {
    public static void main(String[] args) {

    //This sets up the Hibernate configuration by reading the configuration file
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    //The code opens a new session using the openSession() method on the SessionFactory class
        //A session represents a single-threaded unit of work with the database
    Session session = factory.openSession();
    //The beginTransaction() method is called on the session object to start a new DB tansaction
    Transaction ts = session.beginTransaction();
    User uone = new User();
    /*The commit() method is called on the Transaction object to commit the transaction, persisting
     any changes made during the session to the DB   */
    ts.commit();
    System.out.println("successfully created user table");
    /*The close() method is called on the session object to close the session and release any resources
    associated with it.*/
    session.close();

}

}
