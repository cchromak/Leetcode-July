package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.tree.TreeNode;
import java.util.*;

public class WeekOne {


/*  1)
    You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
    Given n, find the total number of full staircase rows that can be formed.
    n is a non-negative integer and fits within the range of a 32-bit signed integer.

    n = 5

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤

    Because the 3rd row is incomplete, we return 2.*/



    public int arrangeCoins(int n) {
        int count = 0;
        int step = 1;
        while(n > 0) {
            n -= step;
            step++;
            count++;
        }
        if (n == 0) {
            return count;
        } else {
            return --count;
        }
    }




     /* 2)
        Given a binary tree, return the bottom-up level order traversal of its nodes' values.
        (ie, from left to right, level by level from leaf to root).


     Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            Stack<List<Integer>> hold = new Stack<>();
            List<List<Integer>> answer = new ArrayList<>();

            if(root == null) {
                return hold;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                List<Integer> currentRow = new ArrayList<>();
                int length = queue.size();
                for (int i = 0; i < length; i++){
                    TreeNode current = queue.remove();
                    currentRow.add(current.val);
                    if (current.left != null) {
                        queue.add(current.left);
                    }
                    if (current.right != null) {
                        queue.add(current.right);
                    }
                }
                hold.push(currentRow);
            }

            while (!hold.isEmpty()) {
                answer.add(hold.pop());
            }

            return answer;
        }
    }
    */


/*  3)

    There are 8 prison cells in a row, and each cell is either occupied or vacant.

    Each day, whether the cell is occupied or vacant changes according to the following rules:

    If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
    Otherwise, it becomes vacant.
            (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

    We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

    Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

    Input: cells = [0,1,0,1,1,0,0,1], N = 7
    Output: [0,0,1,1,0,0,0,0]
    Explanation:
    The following table summarizes the state of the prison on each day:
    Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
    Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
    Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
    Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
    Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
    Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
    Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
    Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
    */


    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0) {
            return cells;
        }
        int[] temp = new int[cells.length];
        N = N % 14 == 0 ? 14 : N % 14;

        while (N-- > 0) {
            for (int i = 0; i < cells.length; i++) {
                if(occupied(cells, i)) {
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }

            for (int i = 0; i < cells.length; i++) {
                cells[i] = temp[i];
            }
        }

        return cells;
    }

    public boolean occupied(int[] cellArr, int i) {
        if (i == 0 || i == cellArr.length - 1) {
            return false;
        }
        if ((cellArr[i - 1] == 0 && cellArr[i + 1] == 0) || (cellArr[i - 1] == 1 && cellArr[i + 1] == 1)) {
            return true;
        } else {
            return false;
        }
    }


    /* 4)

    Write a program to find the n-th ugly number.

    Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

    Example:

    Input: n = 10
    Output: 12
    Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
    Note:

    1 is typically treated as an ugly number.
    n does not exceed 1690.*/


    public int nthUglyNumber(int n) {
        if(n <= 0) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);

        int i=0;
        int j=0;
        int k=0;

        while(list.size() < n){
            int m2 = list.get(i) * 2;
            int m3 = list.get(j) * 3;
            int m5 = list.get(k) * 5;

            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);

            if(min == m2)
                i++;

            if(min == m3)
                j++;

            if(min == m5)
                k++;
        }

        return list.get(list.size() - 1);
    }

    /* 5)

    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

    Given two integers x and y, calculate the Hamming distance.

            Note:
            0 ≤ x, y < 231.

    Example:

    Input: x = 1, y = 4

    Output: 2

    Explanation:
            1   (0 0 0 1)
            4   (0 1 0 0)
            ↑   ↑

    The above arrows point to positions where the corresponding bits are different.*/

    public int hammingDistance(int x, int y) {
        int i = x^y;
        return Integer.bitCount(i);
    }


    /* 6)

    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.

            Example 1:

    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Example 2:

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.*/

    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        if (digits[end] != 9) {
            digits[end]++;
            return digits;
        }
        if (digits.length == 1 && digits[0] == 9) {
            int[] smallResult = new int[2];
            smallResult[0] = 1;
            smallResult[1] = 0;
            return smallResult;
        }
        for (int i = 1; i <= end; end--) {
            if (digits[end] == 9 || digits[end] == 10) {
                digits[end] = 0;
                digits[end - 1]++;
                if (digits[end - 1] < 10) {
                    break;
                }
            }
        }
        if (digits[0] == 10) {
            int[] extendedResult = new int[digits.length + 1];
            extendedResult[0] = 1;
                for (int i = 1; i < extendedResult.length; i++) {
                    extendedResult[i] = 0;
                }
            return extendedResult;
        }
        return digits;
    }


    /*7)

    You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

    The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



    Example:

    Input:
            [[0,1,0,0],
            [1,1,1,0],
            [0,1,0,0],
            [1,1,0,0]]

    Output: 16

    Explanation: The perimeter is the 16 yellow stripes in the image below:*/



    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += (4 - amountOfNeighbors(grid, i, j));
                }
            }
        }
        return perimeter;
    }

    public int amountOfNeighbors(int[][] matrix, int x, int y) {
        int result = 0;

        if (x > 0 && matrix[x - 1][y] == 1) {
            result++;
        }

        if (y > 0 && matrix[x][y - 1] == 1) {
            result++;
        }

        if (y < matrix[x].length - 1 && matrix[x][y + 1] == 1) {
            result++;
        }

        if (x < matrix.length - 1 && matrix[x + 1][y] == 1) {
            result++;
        }

        return result;
    }

    }








