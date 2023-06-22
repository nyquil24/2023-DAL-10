package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdatingUser {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        User u = new User();
        u.setId(3);
        u.setEmail("mhaseeb@persholas");
        u.setFullname("M haseeb");

        /*The merge() method is invoked on the Session object to save or update the User
        * object in the database. This operation merges the state of the provided object into the
        * persistent context of the session.  */
        session.merge(u);
        session.getTransaction().commit();
        session.close();
    }

}
