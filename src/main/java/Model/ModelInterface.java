package Model;

import javafx.beans.property.SimpleStringProperty;

public interface ModelInterface //extends UnnamedPropertyChangeSubject
{
  void reserveVinyl(Vinyl vinyl, String name) throws IllegalArgumentException, IllegalStateException;

  void borrowVinyl(Vinyl vinyl, String name) throws IllegalArgumentException, IllegalStateException;

  void returnVinyl(Vinyl vinyl);

  Vinyl getVinyl(SimpleStringProperty vinylName);

}
