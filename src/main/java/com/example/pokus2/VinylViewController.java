package com.example.pokus2;

import Model.Available;
import Model.State;
import Model.Vinyl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class VinylViewController
{
  private Vinyl vinyl;
  private VinylList vinylList;

  private State state;
  private Available vinylAvailable;

  @FXML
  private Button aReturn;

  @FXML
  private Label status;

  @FXML
  private Button borrow;

  @FXML
  private ComboBox<String> comboBox;

  @FXML
  private Button listGui;

  @FXML
  private TextField nameField;
  private String name;

  @FXML
  private Button reserve;

  @FXML
  void aReturn(ActionEvent event) {
    vinyl = vinylList.getVinylByName(comboBox.getValue());
    vinyl.returnVinyl();
  }

  @FXML
  void borrow(ActionEvent event) {
    vinyl = vinylList.getVinylByName(comboBox.getValue());
    vinyl.borrow(nameField.getText());

  }

  @FXML
  void comboBox(ActionEvent event) {
    //status.setText(String.valueOf(vinyl.getState(vinylList.getVinylByName(comboBox.getSelectionModel().getSelectedItem()))));
    vinyl = vinylList.getVinylByName(comboBox.getSelectionModel().getSelectedItem());
    status.setText(vinyl.getState().toString());
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
    vinyl = vinylList.getVinylByName(comboBox.getValue());
    vinyl.reserve(nameField.getText());
  }


  public void initialize()
  {
    vinylList=new VinylList();

    comboBox.setItems(vinylList.vinyl);
  }
}
