package com.agys.utils;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author aila.bogasieru@agys.ch
 *
 */

public class DbConnection {

    private static DbConnection db = null;
    private Connection con = null;
    private Statement stmt = null;

    private DbConnection()
    {
        try {
            // instantiate com.mysql.jdbc.Driver. This object registers itself with the DriverManager
            Class.forName("com.postegresql.jdbc.Driver");

            //ask the DriverManager for a connection to the schema mysql with root privilleges
            con = DriverManager.getConnection("jdbc:mysql:/localhost:3306/mysql", "root", "root");

            stmt = con.createStatement();

        } catch (SQLException ex) {
            System.out.println("cannot query the database");
        }
        catch (ClassNotFoundException ex) {
            System.out.println("cannot connect to PostgreSQL database");
        }
    }

    public static DbConnection create()
    {
        if(db == null)
        {
            db = new DbConnection();
        }
        return db;
    }

    public ResultSet select(String sql)
    {
        try {
            return stmt.executeQuery(sql);
        } catch (SQLException ex) {
            return null;
        }
    }

    public void close()
    {
        if(con != null)
        {
            try{
                stmt.close();
                con.close();
            }catch(Exception e){}
        }
    }

    public void finalize()
    {
        close();
    }

}


 //   To use this class execute the static method create()

  //      DbConnection db = DbConnection.create();
  //DbConnection db = new DbConnection();
 // );
