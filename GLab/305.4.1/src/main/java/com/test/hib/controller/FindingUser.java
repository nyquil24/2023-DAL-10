package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FindingUser {
    public static void main(String[] args) {

        /* A SessionFactory object is created, which is responsible for creating and managing
        * DB connections. It use theHibernate Configuration class to configure the session factory
        * based on the configuration file. */
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        /* This lines opens a new Hibernate session using the session factory created in the
        * previous step. The session represents a single unit of work and provides methods to
        * perform DB operations */
        Session session = factory.openSession();
        /*Starts a new DB transaction within the current session. A transaction is a sequence of DB
        * operations that are treated as a single unit of work. It allows you to perform multiple
        * operations atomically, ensuring consistency and data integrity. */
        Transaction tx = session.beginTransaction();

        int USER_ID = 2;

        /*This line retrieves a User object from the DB using the provided user ID. The load()
        * method is used to fetch an entity by its identifier. It returns a proxy object representing
        * the entity, and the actual DB query is executed only when you access the properties
        * of the returned object */
        User u = session.load(User.class, USER_ID);
        System.out.println("Fullname: " + u.getFullname());
        System.out.println("Email: " + u.getEmail());
        System.out.println("password: " + u.getPassword());

        /*This line commits the transaction, making the changes(if any) permanent in the DB */
        tx.commit();
        /*This line closes the session factory, releasing any resources associated with it.*/
        factory.close();
        /*This line closes the session, releasing any resource associated with it. */
        session.close();

    }
}
