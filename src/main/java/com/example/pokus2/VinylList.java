package com.example.pokus2;

import Model.Vinyl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class VinylList
{

  ArrayList<Vinyl> vinyls = new ArrayList<Vinyl>();

  public VinylList(){
    vinyls.add(new Vinyl("Sing Me a Lullaby, My Sweet Temptation", "$uicideboy$", 2022, true ));
    vinyls.add( new Vinyl("STOP STARING AT THE SHADOWS", "$uicideboy$", 2020, true ));

    vinyl = FXCollections.observableArrayList(
        vinyls.get(0).getTitle(),
        vinyls.get(1).getTitle(),
        vinyl3.getTitle(),
        vinyl4.getTitle(),
        vinyl5.getTitle(),
        vinyl6.getTitle(),
        vinyl7.getTitle(),
        vinyl8.getTitle(),
        vinyl9.getTitle(),
        vinyl10.getTitle()
    );
  }

  Vinyl vinyl3 = new Vinyl("My Liver Will Handle What My Heart Can't", "$uicideboy$", 2015, false );
  Vinyl vinyl4 = new Vinyl("I Want to Die in New Orleans", "$uicideboy$", 2018, false );
  Vinyl vinyl5 = new Vinyl("Radical $Uicide", "$uicideboy$", 2016, false );
  Vinyl vinyl6 = new Vinyl("Dark Side Of The Clouds", "$uicideboy$", 2016, true );
  Vinyl vinyl7 = new Vinyl("Long Term Effects of Suffering", "$uicideboy$", 2021, false );
  Vinyl vinyl8 = new Vinyl("Eternal Grey", "$uicideboy$", 2016, false );
  Vinyl vinyl9 = new Vinyl("7th Or St. Tammany", "$uicideboy$", 2015, true );
  Vinyl vinyl10 = new Vinyl("Gray/Grey", "$uicideboy$", 2015, true );

  public ObservableList<String> vinyl;

  public Vinyl getVinylByName(String name){
    return vinyls.stream().filter(vinyl -> vinyl.getTitle().equals(name)).findFirst().orElse(null);
  }
}
