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
   
       res.setContentType("text/plain");
    PrintWriter out = res.getWriter();
    DBLogic.kapcsolatNyit();
    out.println(DBLogic.kapcsolatTeszt());
    DBLogic.kapcsolatZár();
      
  }
}
