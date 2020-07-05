package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1)
        WeekOne coin = new WeekOne();
        System.out.println(coin.arrangeCoins(6));


        // 2)
        WeekOne cells = new WeekOne();
        int[] jail = {0,1,0,1,1,0,0,1};
        int x = 7;
        System.out.println(Arrays.toString(cells.prisonAfterNDays(jail, x)));

        // 4)
        WeekOne ugly = new WeekOne();
        System.out.println(ugly.nthUglyNumber(10));



    }
}
