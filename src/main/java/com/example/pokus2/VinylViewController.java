package com.example.pokus2;

import Model.Available;
import Model.State;
import Model.Vinyl;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.Objects;

public class  VinylViewController
{
  private Vinyl vinyl;
  private VinylList vinylList;

  private State state;
  @FXML
  private AnchorPane anchorPane;
  private Available vinylAvailable;

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
  private Button removeVinyl;

  @FXML
  private TextField nameField;
  private String name;

  @FXML
  private Button reserve;

  @FXML
  void aReturn(ActionEvent event) {
    vinyl = vinylList.getVinylByName(comboBox.getValue().getTitle());
    vinyl.returnVinyl();
    status.setText(vinyl.getState().toString());
  }

  @FXML
  void borrow(ActionEvent event) {
    System.out.println("BORROW");
    vinyl = vinylList.getVinylByName(comboBox.getValue().getTitle());
    vinyl.borrow(nameField.getText());
    status.setText(vinyl.getState().toString());
  }

  @FXML
  void reserve(ActionEvent event) {
    System.out.println("RESERVE");
    vinyl = vinylList.getVinylByName(comboBox.getValue().getTitle());
    vinyl.reserve(nameField.getText());
    status.setText(vinyl.getState().toString());
  }

  @FXML
  void comboBox(ActionEvent event) {
    //status.setText(String.valueOf(vinyl.getState(vinylList.getVinylByName(comboBox.getSelectionModel().getSelectedItem()))));
    vinyl = vinylList.getVinylByName(comboBox.getSelectionModel().getSelectedItem().getTitle());
    status.setText(vinyl.getState().toString());
  }

  @FXML
  void listGui(ActionEvent event) throws IOException {
    AnchorPane anchor = FXMLLoader.load(getClass().getResource("VinylList.fxml"));
    anchorPane.getChildren().setAll(anchor);
  }

  @FXML
  void removeVinyl(ActionEvent event) {
    System.out.println("REMOVED");
    if(Objects.equals(vinyl.getState().toString(), "Available")) {
      vinylList.getVinyls().removeIf(obj -> Objects.equals(obj.getTitle(), comboBox.getValue().getTitle()));
    } else {
      vinyl.setToBeRemoved(true);
    }
  }

  @FXML
  void nameField(ActionEvent event) {
    //name = nameField.getText();
  }


  public void initialize()
  {
    vinylList= VinylList.getInstance();

    comboBox.setConverter(new StringConverter<Vinyl>() {
      @Override
      public String toString(Vinyl film) {
        return film.getTitle();
      }

      @Override
      public Vinyl fromString(String string) {
        return null;
      }
    });
    comboBox.setItems(vinylList.getVinyls());
  }
}
