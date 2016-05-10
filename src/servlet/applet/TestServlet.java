/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.applet;

/**
 *
 * @author Kornél
 */
//http://docstore.mik.ua/orelly/java-ent/servlet/ch09_01.htm

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TestServlet extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    res.setContentType("text/html");
    PrintWriter out = res.getWriter(); 

    try {
      // Load (and therefore register) the Oracle Driver
      Class.forName("oracle.jdbc.driver.OracleDriver"); 
     
      // Get a Connection to the database
      con = DriverManager.getConnection(
        "jdbc:oracle:thin:@dbhost:1528:ORCL", "HR", "hr");
     
      // Create a Statement object
      stmt = con.createStatement();
     
      // Execute an SQL query, get a ResultSet
      rs = stmt.executeQuery("SELECT NAME, PHONE FROM EMPLOYEES");
     
      // Display the result set as a list
      out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
      out.println("<BODY>");
      out.println("<UL>");
      while(rs.next()) {
        out.println("<LI>" + rs.getString("name") + " " + rs.getString("phone"));  
      } 
      out.println("</UL>");
      out.println("</BODY></HTML>");
    }
    catch(ClassNotFoundException e) { 
      out.println("Couldn't load database driver: " + e.getMessage());
    }
    catch(SQLException e) { 
      out.println("SQLException caught: " + e.getMessage());
    }
    finally {
      // Always close the database connection.
      try {
        if (con != null) con.close();
      }
      catch (SQLException ignored) { }
    }
  }
}
