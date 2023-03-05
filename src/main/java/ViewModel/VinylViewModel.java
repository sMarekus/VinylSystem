package ViewModel;

import Model.ModelInterface;
import Model.State;
import Model.Vinyl;
import javafx.beans.property.SimpleStringProperty;

public class VinylViewModel
{
  private SimpleStringProperty name;
  private Vinyl vinyl;
  private SimpleStringProperty vinylName;
  private State state;
  private ModelInterface model;

  public VinylViewModel(ModelInterface model){
    this.model = model;
    this.name = name;
    this.vinyl = vinyl;
    this.state = state;
    this.vinylName = vinylName;
  }

  public void clear(){
    vinylName.set("");
    name.set("");
  }

  //podmienky?

  public SimpleStringProperty getNameProperty(){
    return name;
  }

  public SimpleStringProperty getVinylNameProperty(){
    return vinylName;
  }

  public State getStateProperty(){
    return state;
  }
}
