package org.example.Controller;

import org.example.Daointerface.BookDao;
import org.example.Daointerface.ConnectionDAO;
import org.example.model.Books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaolmpl extends ConnectionDAO implements BookDao {

/*
The saveBook method takes a list of Books objects as input and saves them to the DB. It establishes
a DB connection using the ConnectionDAO.getconnection() method.Then it iterates over the list of books and
inserts each book's ISBN and book name into the "books" table using a parameterized SQL query.

 */
    public void saveBook(List<Books> BookList) {
        try {
            Connection con = ConnectionDAO.getConnection();
            for (Books b : BookList) {
                String sqlQuery = "INSERT INTO books(isbn,bookName) VALUES (?,?)";
                PreparedStatement prepStmt = con.prepareStatement(sqlQuery);
                prepStmt.setInt(1, b.getIsbn());
                int affectedRows = prepStmt.executeUpdate();
                System.out.println(affectedRows + " row(s) affected !!");
            }
        } catch (ClassNotFoundException e) {
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
/*
The getAllBooks method retrieves all books from the "books" table. It establishes DB connection.
creates a statement, and executes an SQL query to select all rows from the "books" table.
The retrieved data is then stored in a list of "Books" objects, and the list is returneed.
 */
    public List<Books> getAllBooks() {
        try {
            Connection connection = ConnectionDAO.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            List boollist = new ArrayList();
            while (rs.next()) {
                Books b = new Books();
                b.setIsbn(rs.getInt("isbn"));
                b.setBookName(rs.getString("bookName"));
                boollist.add(b);
            }
            return boollist;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
/*
The udateBook method updates a specific book in the "books" table based on the provided book object
and book ID. It establishes a DB conneciton, prepares an SQL update statement with placeholders for
the ISBN, book name, and ID, and set the values using the 'bookObj' and 'id' parameters. The statement
is then executed and if one row is affected(updated), it retuns 'true'; otherwise, it returns 'false'

 */
    public boolean updateBook(Books bookObj, int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("UPDATE books SET isbn=?,bookName=? WHERE id=?");
            ps.setInt(1, bookObj.getIsbn());
            ps.setInt(3, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
        return false;
    }
/*
Theh deleteBook method deletes a specific book from the "books" table based on the provided book ID. It
establishes a DB connection, prepares an SQL delete statement with a placeholder for the ID, sets the
value using the 'id' parameter, and executes the statement. If one row is affected(deleted), it returns
'true'; otherwise, it returns 'false'.
 */
    public boolean deleteBook(int id) {
        try {
            Connection connection = ConnectionDAO.getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM books WHERE id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            System.err.format("SQL State: %s\n%s", ex.getSQLState(), ex.getMessage());
        }
        return false;
    }
}


