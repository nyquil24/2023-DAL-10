package com.test.hib.controller;

import com.test.hib.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

public class FindUser_Hql {

    public void findUser(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM User"; //Example of HWL to get all records of user class
        TypedQuery query = session.createQuery(hql);
        List<User> results = query.getResultList();
        for(User u : results){
            System.out.println("User Id: " +u.getId() + "|" + " Full name:" +
                    u.getFullname() + "|" + "Email: " + u.getEmail() +"|" +"password" +
                    u.getPassword());
        }

    }

    public void findUserSelect(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        /*------- Example of HQL to get all the records-------*/
        String hql = "SELECT u FROM User u";
        Query query = session.createQuery(hql);
        List<User> list = query.getResultList();

        for(User u : list){
            System.out.println("User Id: " +u.getId()+"|" + " Full name:" + u.getFullname() +"|"+
            "Email: " + u.getEmail() + "|" + "password" + u.getPassword());
        }

    }

    public void getRcordbyId(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "FROM User E WHERE E.id > 2 ORDER BY E.salary DESC";
        TypedQuery query =  session.createQuery(hql);
        List<User> results = query.getResultList();
        for(User u : results){
            System.out.println("User Id: " +u.getId() + "|" + " Full name:" +  u.getFullname()
            + "|"+ "Email: " + u.getEmail() + "|" + "password" + u.getPassword());
        }
    }

    public void getrecords(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        TypedQuery<Object[]> queryy = session.createQuery(
                "SELECT U.salary, U.fullname FROM User AS U", Object[].class);
        List<Object[]> resultss = queryy.getResultList();
        for(Object[] a : resultss){
            System.out.println("Salary: " + a[0] + ",City: " + a[1]);
        }

    }

    public void getmaxSalary(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        String hql = "SELECT max(U.salary) FROM User U";
        TypedQuery query = session.createQuery(hql);
        double result = (double) query.getSingleResult();
        System.out.println(result);
    }

}
