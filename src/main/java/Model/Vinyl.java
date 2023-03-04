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
      state.onReserved(this, name);
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

  public State getState()
  {
    return state;
  }

  public SimpleStringProperty titleProperty() {
    return title;
  }

  public void setTitle(String title) {
    this.title.set(title);
  }

  public String getArtist() {
    return artist.get();
  }

  public SimpleStringProperty artistProperty() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist.set(artist);
  }

  public int getYear() {
    return year.get();
  }

  public SimpleIntegerProperty yearProperty() {
    return year;
  }

  public void setYear(int year) {
    this.year.set(year);
  }

  public SimpleStringProperty reservedByProperty() {
    return reservedBy;
  }

  public void setReservedBy(String reservedBy) {
    System.out.println(reservedBy);
    this.reservedBy.set(reservedBy);
  }

  public SimpleStringProperty borrowedByProperty() {
    return borrowedBy;
  }

  public void setBorrowedBy(String borrowedBy) {
    this.borrowedBy.set(borrowedBy);
  }
}
