package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;

public class Vinyl
{
  private SimpleStringProperty title;
  private SimpleStringProperty artist;
  private SimpleIntegerProperty year;
  private State state;
  private SimpleStringProperty reservedBy;
  private SimpleStringProperty borrowedBy;

  public Vinyl(String title, String artist, int year){
    this.title = new SimpleStringProperty(title);
    this.artist = new SimpleStringProperty(artist);
    this.year = new SimpleIntegerProperty(year);
    this.state = new Available();
    this.reservedBy = new SimpleStringProperty("");
    this.borrowedBy = new SimpleStringProperty("");
  }

  public void borrow() {
    if (borrowedBy.equals("") && reservedBy.equals("")) {

    }
  }

  public void reserve() {

  }

  public void returnVinyl() {

  }

  public void setState(State state) {

  }

}
