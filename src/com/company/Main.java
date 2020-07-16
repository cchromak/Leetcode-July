package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*// 1)
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

        // 7)
        System.out.println("-------------------------------");
        System.out.println("Day 7");
        int[][] island = {{0,1,1,0}, {0,1,1,0}, {0,1,1,0}, {0,1,1,0}};
        WeekOne perm = new WeekOne();
        System.out.println((perm.islandPerimeter(island)));

        //8
        System.out.println("-------------------------------");
        System.out.println("Day 8");
        int[] sumOfNumbers = {-1, -1, 0, 0, 0, 1, 2, -1, -4};
        WeekTwo sum = new WeekTwo();
        System.out.println(sum.threeSum(sumOfNumbers));

        //9
        System.out.println("-------------------------------");
        System.out.println("Day 8");
        WeekTwo binaryTreeWidth = new WeekTwo();
        WeekTwo.TreeNode root = new WeekTwo.TreeNode(34);
        root.left = new WeekTwo.TreeNode(12);
        root.left.left = new WeekTwo.TreeNode(11);
        root.right = new WeekTwo.TreeNode(78);
        root.right.left = new WeekTwo.TreeNode(50);
        System.out.println(binaryTreeWidth.widthOfBinaryTree(root));

        //10
        System.out.println("-------------------------------");
        System.out.println("Day 10");
        WeekTwo.Node head = new WeekTwo.Node(1, null, null, null);
        WeekTwo.Node sec = new WeekTwo.Node(2, head, null, null);
        head.next = sec;
        WeekTwo.Node third = new WeekTwo.Node(3, sec, null, null);
        sec.next = third;
        WeekTwo.Node secondHead = new WeekTwo.Node(11, null, null, null);
        third.child = secondHead;
        WeekTwo.Node secondSec = new WeekTwo.Node(12, secondHead, null, null);
        secondHead.next = secondSec;
        WeekTwo.Node fourth = new WeekTwo.Node(4, third, null, null);
        third.next = fourth;
        WeekTwo flat = new WeekTwo();
        WeekTwo.Node curr = flat.flatten(head);
        while (curr != null) {
            System.out.print(curr.val + "  ");
            curr = curr.next;
        }*/

        // 11)
        System.out.println("-------------------------------");
        System.out.println("Day 11");
        WeekTwo sub = new WeekTwo();
        int[] subTest = {1, 2, 3, 4};
        System.out.println(sub.subsets(subTest));


        // 12)
        System.out.println("-------------------------------");
        System.out.println("Day 12");

        WeekTwo bin = new WeekTwo();
        int w2numb11 = 234523190;
        System.out.println(bin.reverseBits(w2numb11));

        // 13)
        System.out.println("-------------------------------");
        System.out.println("Day 13");

        WeekTwo.TreeNode rootOne = new WeekTwo.TreeNode(34);  // creating first tree
        rootOne.left = new WeekTwo.TreeNode(12);
        rootOne.left.left = new WeekTwo.TreeNode(11);
        rootOne.right = new WeekTwo.TreeNode(78);
        rootOne.right.left = new WeekTwo.TreeNode(50);

        WeekTwo.TreeNode rootTwo = new WeekTwo.TreeNode(34);  // creating second identical tree
        rootTwo.left = new WeekTwo.TreeNode(12);
        rootTwo.left.left = new WeekTwo.TreeNode(11);
        rootTwo.right = new WeekTwo.TreeNode(78);
        rootTwo.right.left = new WeekTwo.TreeNode(50);

        WeekTwo same = new WeekTwo();
        System.out.println(same.isSameTree(rootOne, rootTwo));

        // 14)
        System.out.println("-------------------------------");
        System.out.println("Day 14");

        WeekTwo clock = new WeekTwo();
        System.out.println(clock.angleClock(6, 30));

    }
}
