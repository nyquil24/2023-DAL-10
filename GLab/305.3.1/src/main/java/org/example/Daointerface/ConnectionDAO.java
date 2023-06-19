package org.example.Daointerface;

import java.sql.*;


public class ConnectionDAO {

    static Connection con = null; //  will hold the DB connection once it is established.
    protected PreparedStatement ps = null; // These variables will be used later for executing SQL queries
    protected ResultSet rs = null; //and retrieving results from the DB

    public static Connection getConnection() throws ClassNotFoundException {
        final String DBURL = "jdbc:mysql://localhost:3306/library";
        final String DBUSERNAME = "root";
        final String DBPASSWORD = "connection";
        try {
            con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD); // method is called to establish a conn
            System.out.println("Connected Database Successfully");// to the DB
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    return con; // the con variable, which holds the DB conn, is returned by the getConnection() method.
    }
    public void disconnect() {
        try{
            if(rs != null){
                rs.close();
            }
            if(ps != null){
                ps.close();
            }
            if(con != null){
                con.close();
            }
        } catch(Exception e){
            //todo: handle exception
        }
    }

}

