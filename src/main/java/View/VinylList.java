package View;

import Model.Vinyl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class VinylList
{
  private ObservableList<Vinyl> vinyls;

  private static VinylList INSTANCE = new VinylList();
  public VinylList(){
    vinyls = FXCollections.observableArrayList(
      new Vinyl("Sing Me a Lullaby, My Sweet Temptation", "$uicideboy$", 2022),
      new Vinyl("STOP STARING AT THE SHADOWS", "$uicideboy$", 2020),
      new Vinyl("My Liver Will Handle What My Heart Can't", "$uicideboy$", 2015),
      new Vinyl("I Want to Die in New Orleans", "$uicideboy$", 2018),
      new Vinyl("Radical $Uicide", "$uicideboy$", 2016),
      new Vinyl("Dark Side Of The Clouds", "$uicideboy$", 2016),
      new Vinyl("Long Term Effects of Suffering", "$uicideboy$", 2021),
      new Vinyl("Eternal Grey", "$uicideboy$", 2016),
      new Vinyl("7th Or St. Tammany", "$uicideboy$", 2015),
      new Vinyl("Gray/Grey", "$uicideboy$", 2015)
    );
  }

  public Vinyl getVinyl(int i){
    return vinyls.get(i);
  }

  public static VinylList getInstance() {
    return INSTANCE;
  }
  public ObservableList<Vinyl> getVinyls() {
    return vinyls;
  }
  public Vinyl getVinylByNameAgain(String name){
    Vinyl target = null;
    for(int i = 0; i<vinyls.size(); i++){
      if(vinyls.get(i).getTitle().equals(name)){
        target = vinyls.get(i);
      }
    }
    return target;
  }


  public Vinyl getVinylByName(String name){
    return vinyls.stream().filter(vinyl -> vinyl.getTitle().equals(name)).findFirst().orElse(null);
  }
}
