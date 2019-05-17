package me.nutsjian.newbie.testdata.factory;

import java.util.Random;

public class FactoryUtils {

    public static int generateRangeRandomInt(int min, int max) {
        return new Random().nextInt(max) % (max-min+1) + min;
    }

    public static void main(String[] args) {
        for (int i=0; i<20; i++) {
            System.out.println(generateRangeRandomInt(0, 20));
        }
    }

}
