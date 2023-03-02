package com.example.pokus2;

import Model.Vinyl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class VinylViewController implements Initializable
{


  ObservableList<String> vinylList = FXCollections.observableArrayList();
  private Vinyl vinyl;

  @FXML
  private Button aReturn;

  @FXML
  private Label status;

  @FXML
  private Button borrow;

  @FXML
  private ComboBox<Vinyl> comboBox;

  @FXML
  private Button listGui;

  @FXML
  private TextField nameField;
  private String name;

  @FXML
  private Button reserve;

  @FXML
  void aReturn(ActionEvent event) {
    /*String vinylName = (String) comboBox.getValue();
    for(int i = 0; i<9; i++){
      if(vinylName.equals((String) vinyl.getVinyl(i).getTitle())){
        vinyl.getVinyl(i).setState(Vinyl.State.AVAILABLE);
      }
    }

     */
  }

  @FXML
  void borrow(ActionEvent event) {
    /*String vinylName = (String) comboBox.getValue();
    for(int i = 0; i<9; i++){
      if(vinylName.equals((String) vinyl.getVinyl(i).getTitle())){
        vinyl.getVinyl(i).setState(Vinyl.State.BORROWED);
      }
    }

     */
  }

  @FXML
  void comboBox(ActionEvent event) {
    //comboBox = new ComboBox(vinylList);
  }

  @FXML
  void listGui(ActionEvent event) {

  }

  @FXML
  void nameField(ActionEvent event) {
    //name = nameField.getText();
  }

  @FXML
  void reserve(ActionEvent event) {
    /*String vinylName = (String) comboBox.getValue();
    for(int i = 0; i<9; i++){
      if(vinylName.equals((String) vinyl.getVinyl(i).getTitle())){
        vinyl.getVinyl(i).setState(Vinyl.State.RESERVED);
      }
    }

     */

  }

  @Override public void initialize(URL location, ResourceBundle resources)
  {
  }
}
