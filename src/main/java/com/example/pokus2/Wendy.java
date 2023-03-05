package com.example.pokus2;

import Model.ModelManager;

import java.util.Random;

public class Wendy implements Runnable {
    private String name = "Wendy";


    @Override
    public void run() {
        Random rand1 = new Random();

        while(true){
            int num = rand1.nextInt(1,4);
            int numOfVinyl = rand1.nextInt(0, ModelManager.getInstance().getVinyls().size());
            int sleep = rand1.nextInt(3000, 5000);
            switch(num){
                case 1:
                    ModelManager.getInstance().getVinyl(numOfVinyl).borrow(name);
                    System.out.println(num);
                    break;


                case 2:
                    ModelManager.getInstance().getVinyl(numOfVinyl).reserve(name);
                    System.out.println(num);
                    break;

                case 3:
                    ModelManager.getInstance().getVinyl(numOfVinyl).returnVinyl(name);
                    System.out.println(num);
                    break;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(num);
            System.out.println("Wendy nieco spravila");
        }

    }
}
