package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        WeekOne coin = new WeekOne();
        System.out.println(coin.arrangeCoins(6));

        WeekOne cells = new WeekOne();
        int[] jail = {0,1,0,1,1,0,0,1};
        int x = 7;
        System.out.println(Arrays.toString(cells.prisonAfterNDays(jail, x)));

    }
}
