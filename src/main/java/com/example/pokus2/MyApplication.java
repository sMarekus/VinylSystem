package com.example.pokus2;

//import View.ViewHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MyApplication extends Application
{
  public void start(Stage primaryStage) throws Exception
  {
    FXMLLoader loader = new FXMLLoader();
    URL fxmlurl = getClass().getResource("VinylView.fxml");
    if(fxmlurl == null){
      System.err.println("file not found");
    }
    else{
      loader.setLocation(fxmlurl);
      Parent root = loader.load();
      Scene scene = new Scene(root);
      primaryStage.setTitle("Assignment 1");
      primaryStage.setScene(scene);
      primaryStage.show();

      Bob bob = new Bob();
      Wendy wendy = new Wendy();

      Thread thread1 = new Thread(bob);
      Thread thread2 = new Thread(wendy);

      thread1.start();
      thread2.start();
    }
  }

  public static void main(String[] args)
  {
    launch(args);


  }
}