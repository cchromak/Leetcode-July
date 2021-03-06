package com.company;

import java.util.*;

public class WeekTwo {

    /* 8)

    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

            Note:

    The solution set must not contain duplicate triplets.

    Example:

    Given array nums = [-1, 0, 1, 2, -1, -4],

    A solution set is:
            [
            [-1, 0, 1],
            [-1, -1, 2]
            ]*/

    public List<List<Integer>> threeSum(int[] nums) {
        int left, right, i, sum;
        List<List<Integer>> rt = new ArrayList<List<Integer>>();
        if (nums.length < 3) return rt;
        Arrays.sort(nums);
        for(i = 0; i < nums.length-2 ; i++){
            sum = 0 - nums[i];
            left = i + 1;
            right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == sum ){
                    rt.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[left] + nums[right] < sum){
                    left++;
                }
                else{
                    right--;
                }
            }

            while(i < nums.length - 2 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return rt;
    }

    /* 9)

    Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width
    among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

    The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the
            level, where the null nodes between the end-nodes are also counted into the length calculation.

            Example 1:

            Input:

            1
            /   \
            3     2
            / \     \
            5   3     9

            Output: 4
            Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).*/


    public static class TreeNode {
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

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int max = 1, leftmost = 1, rightmost = 1;
        root.val = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    leftmost = cur.val;
                }
                if (i == size - 1) {
                    rightmost = cur.val;
                }
                if (cur.left != null) {
                    cur.left.val = cur.val * 2;
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur.val * 2 + 1;
                    queue.offer(cur.right);
                }
            }
            max = Math.max(max, rightmost - leftmost + 1);

        }
        return max;
    }


    /* 10)

    You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer,
    which may or may not point to a separate doubly linked list. These child lists may have one or more children of their
    own, and so on, to produce a multilevel data structure, as shown in the example below.

    Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the
    first level of the list.


    Example 1:

    Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
    Output: [1,2,3,7,8,11,12,9,10,4,5,6]*/

    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node (int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }
    }



    public Node flatten(Node head) {
            if (head == null) {
                return head;
            }
            Node curr = head;
            Deque<Node> stack = new ArrayDeque<>();
            while (curr != null) {
                if (curr.child != null) {
                    if (curr.next != null) {
                        stack.push(curr.next);
                    }

                    curr.next = curr.child;
                    if (curr.next != null) {
                        curr.next.prev = curr;
                    }
                    curr.child = null;
                } else if (curr.next == null && !stack.isEmpty()) {
                    curr.next = stack.pop();
                    if (curr.next != null) {
                        curr.next.prev = curr;
                    }
                }
                curr = curr.next;
            }
            return head;
        }


    /*11)
    // Given a set of distinct integers, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: nums = [1,2,3]
    Output:
            [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
            ]*/

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        return subsets;
        }


    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets( i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    /*  12)
    Reverse bits of a given 32 bits unsigned integer.

    Example 1:

    Input: 00000010100101000001111010011100
    Output: 00111001011110000010100101000000
    Explanation: The input binary string 00000010100101000001111010011100 represents
    the unsigned integer 43261596, so return 964*/


    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }

    /* 13)
    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

            Example 1:

    Input:     1         1
            / \       / \
            2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
    Example 2:

    Input:   1         1
            /           \
            2            2

            [1,2],     [1,null,2]

    Output: false*/


        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) {
                return true;
            } else if (p == null || q == null) {
                return false;
            }

            if(p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }


    /* 14)
    Given two numbers, hour and minutes. Return the smaller angle (in degrees)
    formed between the hour and the minute hand.



    Example 1:



    Input: hour = 12, minutes = 30
    Output: 165*/

    public double angleClock(int hour, int minutes) {

        double hourLoc;
        double minLoc;
        double distanceA;
        double distanceB;

        minLoc = 360 * minutes / 60;

        if (hour != 12) {
            hourLoc =  30 * hour + 30.0 * minutes / 60;
        } else {
            hourLoc = 30.0 * minutes / 60;
        }

        if (hourLoc > minLoc) {
            distanceA = hourLoc - minLoc;
            distanceB = 360 - distanceA;
        } else {
            distanceA = minLoc - hourLoc;
            distanceB = 360 - distanceA;
        }

        if (distanceA <= distanceB) {
            return distanceA;
        } else {
            return distanceB;
        }


    }


}
