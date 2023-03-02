module com.example.pokus2 {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.example.pokus2 to javafx.fxml;
  exports com.example.pokus2;
}