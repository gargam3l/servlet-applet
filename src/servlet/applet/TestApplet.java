/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.applet;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
/**
 *
 * @author Kornél
 */
public class TestApplet extends JApplet{
   TextField httpText, httpObject, socketText, socketObject, RMIObject;
  Button refresh;

  public void init() {
    // Construct the user interface

    setLayout(new BorderLayout());

    // On the left create labels for the various communication
    // mechanisms
    Panel west = new Panel();
    west.setLayout(new GridLayout(5, 1));
    west.add(new Label("HTTP text: ", Label.RIGHT));
    west.add(new Label("HTTP object: ", Label.RIGHT));
    west.add(new Label("Socket text: ", Label.RIGHT));
    west.add(new Label("Socket object: ", Label.RIGHT));
    west.add(new Label("RMI object: ", Label.RIGHT));
    add("West", west);

    // On the right create text fields to display the retrieved time values
    Panel center = new Panel();
    center.setLayout(new GridLayout(5, 1));

    httpText = new TextField();
    httpText.setEditable(false);
    center.add(httpText);

    httpObject = new TextField();
    httpObject.setEditable(false);
    center.add(httpObject);

    socketText = new TextField();
    socketText.setEditable(false);
    center.add(socketText);

    socketObject = new TextField();
    socketObject.setEditable(false);
    center.add(socketObject);

    RMIObject = new TextField();
    RMIObject.setEditable(false);
    center.add(RMIObject);

    add("Center", center);

    // On the bottom create a button to update the times
    Panel south = new Panel();
    refresh = new Button("Refresh");
    south.add(refresh);
    add("South", south);
  }

  public void start() {
    refresh();
  }

  private void refresh() {
    // Fetch and display the time values
    httpText.setText(getDateUsingHttpText());
    httpObject.setText(getDateUsingHttpObject());
    socketText.setText(getDateUsingSocketText());
    socketObject.setText(getDateUsingSocketObject());
    RMIObject.setText(getDateUsingRMIObject());
  }

  private String getDateUsingHttpText() {
    // Retrieve the current time using an HTTP text-based connection
    return "unavailable";
  }

  private String getDateUsingHttpObject() {
    // Retrieve the current time using an HTTP object-based connection
    return "unavailable";
  }

  private String getDateUsingSocketText() {
    // Retrieve the current time using a non-HTTP text-based socket
    // connection
    return "unavailable";
  }

  private String getDateUsingSocketObject() {
    // Retrieve the current time using a non-HTTP object-based socket
    // connection
    return "unavailable";
  }

  private String getDateUsingRMIObject() {
    // Retrieve the current time using RMI communication
    return "unavailable";
  }

  public boolean handleEvent(Event event) {
    // When the refresh button is pushed, refresh the display
    // Use JDK 1.0 events for maximum portability
    switch (event.id) {
      case Event.ACTION_EVENT:
        if (event.target == refresh) {
          refresh();
          return true;
        }
    }
    return false;
  }
  public void displayGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this, BorderLayout.CENTER);
        //frame.getContentPane().add(this);
        //frame.setLayout(cardLayout);
        frame.setTitle("Chlebovics Kornél(VYSQGW) & Papp Zoltán(N3GM04)");
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
