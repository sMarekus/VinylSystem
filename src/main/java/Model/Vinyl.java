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

  public void borrow(String name) {
      state.onBorrow(this,name);
  }

  public void reserve(String name) {
      state.onReserved(this);
  }

  public void returnVinyl() {
      state.onReturn(this);
  }

  public void setState(State state) {
      this.state = state;
  }

  public String getTitle()
  {
    return title.get();
  }

  public String getBorrowedBy() {
    return borrowedBy.get();
  }

  public String getReservedBy() {
    return borrowedBy.get();
  }
}
