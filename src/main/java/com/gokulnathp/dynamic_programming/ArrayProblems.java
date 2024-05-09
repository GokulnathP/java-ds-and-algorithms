package com.gokulnathp.dynamic_programming;

public class ArrayProblems {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int price: prices) {
            minValue = Math.min(minValue, price);
            int profit = price - minValue;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    public static int maxSubarray(int[] nums) {
        if(nums.length == 0) return 0;

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void rotation(int[] nums, int k) {
        k = k % nums.length;

        for(int start = 0, end = nums.length - k - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        for(int start = nums.length - k, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        for(int start = 0, end = nums.length - 1; start < end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

    public static void rotateV1(int[] nums, int k) {
        if(nums.length <= 1) return;

        int rotation = k % nums.length;

        for (int i = 0; i < rotation; i++) {
            int prev = nums[nums.length - 1];
            int current = nums[0];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = prev;
                prev = current;
                current = nums[j + 1];
            }
        }
    }
}
