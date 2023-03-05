package com.example.pokus2;

import Model.Vinyl;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class VinylListViewController implements Initializable
{

  private Vinyl vinyl;
  private VinylList vinylList;
  @FXML
  private TableView<Vinyl> tableView;

  @FXML
  private AnchorPane pane2;

  @FXML
  private TableColumn<Vinyl, String> artistCol;

  @FXML
  private TableColumn<Vinyl, String> nameCol;

  @FXML
  private TableColumn<Vinyl, String> statusCol;

  @FXML
  private TableColumn<Vinyl, String>titleCol;

  @FXML
  private TableColumn<Vinyl, Integer> yearCol;
  @FXML
  private Button back;

  @FXML
  void goBack(ActionEvent event) throws IOException
  {
    AnchorPane anchor = FXMLLoader.load(getClass().getResource("VinylView.fxml"));
    pane2.getChildren().setAll(anchor);
  }


  @Override public void initialize(URL location, ResourceBundle resources)
  {
    vinylList = VinylList.getInstance();

    titleCol.setCellValueFactory(f -> new SimpleObjectProperty<>(f.getValue().getTitle()));
    artistCol.setCellValueFactory(f -> new SimpleObjectProperty<>(f.getValue().getArtist()));
    yearCol.setCellValueFactory(f -> new SimpleObjectProperty<>(f.getValue().getYear()));
    statusCol.setCellValueFactory(f -> new SimpleObjectProperty<>(f.getValue().getState().toString()));

    nameCol.setCellValueFactory(f -> new SimpleObjectProperty<>(Objects.equals(f.getValue().getState().toString(), "Available") ? "" : Objects.equals(f.getValue().getState().toString(), "Borrowed") || Objects.equals(f.getValue().getState().toString(), "BorrowedAndReserved") ? f.getValue().getBorrowedBy() : f.getValue().getReservedBy()));

    tableView.setItems(vinylList.getVinyls());

    System.out.println(vinylList.getVinyls().get(0).getReservedBy() + vinylList.getVinyls().get(0).getBorrowedBy() + "test");

    vinylList.getVinyls().addListener((ListChangeListener<Vinyl>) c -> {
      System.out.println("neide.");
      tableView.refresh();
    });
  }

}