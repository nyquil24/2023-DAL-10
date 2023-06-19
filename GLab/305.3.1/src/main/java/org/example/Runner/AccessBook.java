package org.example.Runner;

import org.example.Controller.BookDaolmpl;
import org.example.Daointerface.BookDao;
import org.example.model.Books;

import java.sql.SQLException;
import java.util.ArrayList;

public class AccessBook {
    public static void main(String[] args) {
        //CRUD and business Logic will be invoked here

        //creating object
       BookDao bookDao = new BookDaolmpl();
//        System.out.println("----------inserting book records ----------");
//
//        ArrayList<Books> BookList = new ArrayList<Books>();
//
//        Books b1 = new Books();
//        b1.setIsbn(120);
//        b1.setBookName("Java Book");
//        BookList.add(b1);
//
//        Books b2 = new Books();
//        b2.setIsbn(300);
//        b2.setBookName("Python Book");
//        BookList.add(b2);
//
//        Books b3 = new Books();
//        b3.setIsbn(365);
//        b3.setBookName("JavaScript Book");
//        BookList.add(b3);
//
//        Books b4 = new Books();
//        b4.setIsbn(256);
//        b4.setBookName("Sql Book");
//        BookList.add(b4);
//        https://www.tiktok.com/t/ZT8JRm2Dg/
//        bookDao.saveBook(BookList);
        System.out.println("===== Display list of all books ===== ");
        try{
            for(Books cc: bookDao.getAllBooks()){
                int ISBN = cc.getIsbn();
                String BookName = cc.getBookName();
                System.out.println("==============");
                System.out.println("ISBN Number : " + ISBN + " and Book name: " + BookName);
            }
        }  catch(ClassNotFoundException e){
            e.printStackTrace();

        } catch (SQLException e){
            e.printStackTrace();
        }


  }
}
