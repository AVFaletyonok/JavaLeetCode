package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        int count = minSubarray(new int[]{6, 3, 5, 2}, 9);
//        int count = minSubarray(new int[]{26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3}, 26);

        int[] array = new int[10000];
        Arrays.fill(array, 1);
        array[0] = 1000000000;
        int count = minSubarray(array, 1000000000);

        System.out.println(count);
    }

    // Prefix Sum Modulo - O(n)
    public static int minSubarray(int[] nums, int p) {
        long sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        int target = (int)(sum % p);
        if (target == 0) {
            return 0;
        }
        Map<Integer, Integer> modMap = new HashMap();
        modMap.put(0, -1);
        int currentSum = 0;
        int minLen = len;

        for (int i = 0; i < len; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int needed = (currentSum - target + p) % p;

            modMap.put(currentSum, i);
            if (modMap.containsKey(needed)) {
                int subarrayLen = i - modMap.get(needed);
                if (subarrayLen < minLen) {
                    minLen = subarrayLen;
                }
            }
        }
        if (minLen < len) {
            return minLen;
        } else {
            return -1;
        }
    }

    // Brute force - O(n2)
    public static int minSubarrayN2(int[] nums, int p) {
        long sum = 0;
        long sumRems = 0;
        int len = nums.length;
        int[][] sumMatrix = new int[len][len];
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            sumMatrix[0][i] = nums[i] % p;
            sumRems += sumMatrix[0][i];
        }
        int remainder = (int)(sum % p);
        if (remainder == 0) {
            return 0;
        } else if (sumRems < remainder) {
            return -1;
        }

        if (isDivisibleWithoutOne(sumMatrix, p, remainder)) {
            return 1;
        }
        for (int i = 2; i < len; i++) {
            boolean isDivisible = isDivisibleWithoutSubarray(sumMatrix, p, remainder, i);
            if (isDivisible) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isDivisibleWithoutOne(int[][] sumMatrix, int p, int remainder) {
        int len = sumMatrix.length;
        for (int i = 0; i < len; i++) {
            sumMatrix[1][i] = sumMatrix[0][i];
            if (sumMatrix[1][i] % p == remainder) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDivisibleWithoutSubarray(int[][] sumMatrix, int p, int remainder, int windowSize) {
        int len = sumMatrix.length - windowSize + 1;
        for (int i = 0; i < len; i++) {
            sumMatrix[windowSize][i] = sumMatrix[windowSize - 1][i] + sumMatrix[0][windowSize - 1 + i];
            if (sumMatrix[windowSize][i] % p == remainder) {
                return true;
            }
        }
        return false;
    }
}