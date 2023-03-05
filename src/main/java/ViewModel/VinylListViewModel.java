package ViewModel;

import Model.State;
import Model.Vinyl;
import javafx.beans.property.SimpleStringProperty;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//import java.beans.PropertyChangeEvent;
//import java.beans.PropertyChangeListener;
import Model.ModelInterface;

public class VinylListViewModel //implements PropertyChangeListener
{
  private ModelInterface model;
  private State state;

  public VinylListViewModel(ModelInterface model){
    this.model = model;
  }

  public void update(){

  }

  public State getState(){
    return state;
  }


}
