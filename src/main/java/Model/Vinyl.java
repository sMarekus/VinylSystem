package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Enumeration;

public class Vinyl
{


  ArrayList<Vinyl> vinylList = new ArrayList<Vinyl>();
  ArrayList<Vinyl> borrowList = new ArrayList<Vinyl>();
  ArrayList<Vinyl> reservationList = new ArrayList<Vinyl>();
  ArrayList<Vinyl> combined = new ArrayList<Vinyl>();
  Hashtable<String, Vinyl> reservationHash = new Hashtable<String, Vinyl>();
  private SimpleStringProperty title;
  private SimpleStringProperty artist;
  private SimpleIntegerProperty year;
  private SimpleBooleanProperty available;
  private SimpleStringProperty state;

  private SimpleStringProperty reservationName;

  public enum State{
    RESERVED("reserved"),
    BORROWED("borrowed"),
    AVAILABLE("available");

    private String state;
    State(String state){
      this.state = state;
    }

    public String getState(){
      return state;
    }
  }



  public Vinyl(String title, String artist, int year, boolean available){
    this.title = new SimpleStringProperty(title);
    this.artist = new SimpleStringProperty(artist);
    this.year = new SimpleIntegerProperty(year);
    this.available = new SimpleBooleanProperty(available);
  }

  public Vinyl(String title, String artist, int year, boolean available, State state){
    this.title = new SimpleStringProperty(title);
    this.artist = new SimpleStringProperty(artist);
    this.year = new SimpleIntegerProperty(year);
    this.available = new SimpleBooleanProperty(available);
    this.state = new SimpleStringProperty(State.AVAILABLE.getState());
  }

  public Vinyl(String title, String artist, int year, boolean available, State state, String reservationName){
    this.title = new SimpleStringProperty(title);
    this.artist = new SimpleStringProperty(artist);
    this.year = new SimpleIntegerProperty(year);
    this.available = new SimpleBooleanProperty(available);
    this.state = new SimpleStringProperty(State.AVAILABLE.getState());
    this.reservationName = new SimpleStringProperty(reservationName);
  }

  public String getTitle(){
    return title.get();
  }
  public String getState(){
    return state.get();
  }

  public String getArtist(){
    return artist.get();
  }

  public int getYear(){
    return year.get();
  }

  public boolean getAvailability(){
    return available.get();
  }

  String status="";
  public String isAvailable(Vinyl vinyl){
    for(int i = 0; i < 9; i++){
      if (vinyl.getAvailability() == true){
        status="Available";
      }
      else{
        status="Not available";
      }
    }
    return status;
  }

  public void setAvailability(boolean available){
    this.available = new SimpleBooleanProperty(available);
  }


  public void setState(State state){
    this.state = new SimpleStringProperty(state.getState());
  }

  public String getReservationName(){
    return reservationName.get();
  }

  public void setReservationName(String reservationName){
    this.reservationName = new SimpleStringProperty(reservationName);
  }

  public void reserveVinyl(Vinyl vinyl, String name){
    if(vinyl.getAvailability() && !vinyl.getState().equals(State.RESERVED.getState()) && !vinyl.getState().equals(State.BORROWED.getState())){
      vinyl.setReservationName(name);
      vinyl.setAvailability(false);
      vinyl.setState(State.RESERVED);
      reservationList.add(vinyl);
      reservationHash.put(name, vinyl);
    }
  }

  public void borrowVinyl(Vinyl vinyl){
    if(!vinyl.getState().equals("reserved") && vinyl.getAvailability()){
      vinyl.setState(State.BORROWED);
      borrowList.add(vinyl);
      vinyl.setAvailability(false);
    }
  }

  /*public String getTitlesFromOL(){
    String temp = "";
    for(int i = 0; i<vinyl.size(); i++){
      temp+=vinyl.get(i);
      return temp;
    }
    return null;
  }

   */

  public void returnVinyl(Vinyl vinyl){
    vinyl.setAvailability(true);
    if(vinyl.getState().equals("reserved") || vinyl.getState().equals("borrowed")){
      vinyl.setState(State.AVAILABLE);
    }
    removeBorrowing(vinyl);
    removeReservation(vinyl);
    removeCombined(vinyl);
  }

  public void addToVinylList(Vinyl vinyl){
    vinylList.add(vinyl);
  }

  public String printReservations(){
    Enumeration<String> keys = reservationHash.keys();
    if(reservationHash.size()==0){
      return "There are no reservations.";
    }
    while(keys.hasMoreElements()){
      String key = keys.nextElement();
      return "Name: "+ key +", Model.Vinyl: "+reservationHash.get(key).getTitle();
    }
    return "End of reservation list.";
  }

  public String printBorrowings(){
    String temp = "";
    for(int i = 0; i<borrowList.size(); i++){
      temp+=borrowList.get(i).getTitle()+", ";
    }
    return temp;
  }

  public void removeVinyl(Vinyl vinyl){
    if(!vinyl.getState().equals(State.RESERVED.getState()) || !vinyl.getState().equals(State.BORROWED.getState())){
      returnVinyl(vinyl);
      if(vinyl.getAvailability()){
        for(int i = 0; i<vinylList.size(); i++){
          if(vinylList.get(i)==vinyl){
            vinylList.remove(i);
          }
        }
      }
    }
  }

  public void checkCombined(Vinyl vinyl){
    for(int i = 0; i<reservationHash.size(); i++){
      if(reservationHash.get(i).getTitle().equals(vinyl.getTitle())){
        for(int j = 0; j<borrowList.size(); i++){
          if(borrowList.get(i) == vinyl){
            combined.add(vinyl);
          }
        }
      }
    }
  }

  public String printCombined(){
    String temp = "";
    for(int i = 0; i< combined.size(); i++){
      temp+=combined.get(i).getTitle()+", ";
    }
    return temp;
  }

  public void removeReservation(Vinyl vinyl){
    reservationHash.entrySet().removeIf(entry -> (vinyl.getReservationName() == entry.getKey()));
    vinyl.setState(State.AVAILABLE);
  }


  public void removeBorrowing(Vinyl vinyl){
    for(int i = 0; i<borrowList.size(); i++){
      if(borrowList.get(i) == vinyl){
        borrowList.remove(i);
      }
    }
    vinyl.setState(State.AVAILABLE);
  }

  public void removeCombined(Vinyl vinyl){
    for(int i = 0; i<combined.size(); i++){
      if(combined.get(i) == vinyl){
        combined.remove(i);
      }
    }
    vinyl.setState(State.AVAILABLE);
  }

  public String printVinyls(){
    String temp = "";
    for(int i = 0; i<vinylList.size(); i++){
      temp+=vinylList.get(i).getTitle() + ", ";
    }
    return temp;
  }

  public Vinyl getVinyl(int index){
    return vinylList.get(index);
  }


}
