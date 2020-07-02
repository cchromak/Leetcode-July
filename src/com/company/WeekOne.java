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








}
