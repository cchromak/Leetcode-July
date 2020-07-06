package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1)
        System.out.println("-------------------------------");
        System.out.println("Day 1");
        WeekOne coin = new WeekOne();
        System.out.println(coin.arrangeCoins(6));


        // 2)
        System.out.println("-------------------------------");
        System.out.println("Day 2");
        WeekOne cells = new WeekOne();
        int[] jail = {0,1,0,1,1,0,0,1};
        int x = 7;
        System.out.println(Arrays.toString(cells.prisonAfterNDays(jail, x)));

        // 4)
        System.out.println("-------------------------------");
        System.out.println("Day 4");
        WeekOne ugly = new WeekOne();
        System.out.println(ugly.nthUglyNumber(10));

        // 5)
        System.out.println("-------------------------------");
        System.out.println("Day 5");
        WeekOne bin = new WeekOne();
        int xham = 1;
        int yham = 4;

        System.out.println(bin.hammingDistance(xham, yham));

        // 6)
        System.out.println("-------------------------------");
        System.out.println("Day 6");
        WeekOne addDigit = new WeekOne();
        int[] number = {9, 9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(addDigit.plusOne(number)));



    }
}
