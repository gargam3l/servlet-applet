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
public interface DBConn {
    
  String URL = "jdbc:oracle:thin:@localhost:1521:xe";
  String USER = "HR";
  String PASSWORD = "hr";
  String DRIVER = "oracle.jdbc.driver.OracleDriver";

}
