package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


}
