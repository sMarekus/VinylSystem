package com.example.pokus2;

import View.VinylList;

import java.util.Random;

public class Bob implements Runnable{
    private String name = "Bob";

    @Override
    public void run() {
        Random rand1 = new Random();
        while(true){
            int num = rand1.nextInt(1,4);
            int numOfVinyl = rand1.nextInt(0, VinylList.getInstance().getVinyls().size());
            int sleep = rand1.nextInt(2000, 3000);
            switch(num){
                case 1:
                    VinylList.getInstance().getVinyl(numOfVinyl).borrow(name);
                    System.out.println(num);
                    break;
                case 2:
                    VinylList.getInstance().getVinyl(numOfVinyl).reserve(name);
                    System.out.println(num);
                    break;

                case 3:
                    VinylList.getInstance().getVinyl(numOfVinyl).returnVinyl(name);
                    System.out.println(num);
                    break;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Bob nieco spravil");

        }

    }
}
