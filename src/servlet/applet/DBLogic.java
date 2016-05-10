/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.applet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Kornél
 */
public class DBLogic implements DBConn{
    private static Connection kapcsolat;
    public static void kapcsolatNyit() {
        try {
            Class.forName(DRIVER);
            kapcsolat = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (ClassNotFoundException e) {
            //System.out.println("Hiba! Hiányzik a JDBC driver.");
            throw new RuntimeException("Hiba! Hiányzik a JDBC driver.");
        }
        catch (SQLException e) {
            //System.out.println("Hiba! Nem sikerült megnyitni a kapcsolatot az adatbázis-szerverrel.");
            throw new RuntimeException("Hiba! Nem sikerült megnyitni a kapcsolatot az adatbázis-szerverrel. Kérem ellenőrizze, hogy a \"hr\" felhasználó megfelelően van konfigurálva az Oracle adatbázisban!");
        }
  }

  public static void kapcsolatZár() {
        try {
            kapcsolat.close();
        }
        catch (SQLException e) {
            System.out.println("Hiba! Nem sikerült lezárni a kapcsolatot az adatbázis-szerverrel.");
        }
  }
    public void kapcsolatTeszt()
    {
        try {
            kapcsolatNyit();
            Statement s=kapcsolat.createStatement();
            String sql = "select * from COUNTRIES where REGION_ID=2";
            ResultSet rs=s.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getString("COUNTRY_NAME"));
           }
            kapcsolatZár();
            
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
