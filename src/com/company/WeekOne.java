package com.company;

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








}
