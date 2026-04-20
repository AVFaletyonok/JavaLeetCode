package org.example;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.printf("""
                            LeetCode!
                            Task 2078. Two Furthest Houses With Different Colors
                            ---
                            Running testcase:
                            Case 1:
                            input: colors = [1,1,1,6,1,1,1]
                            output:
                            """);
        System.out.println(maxDistance(new int[] {1,1,1,6,1,1,1}));

        System.out.printf("""
                            ---
                            Case 2:
                            input: colors = [1,8,3,8,3]
                            output:
                            """);
        System.out.println(maxDistance(new int[] {1,8,3,8,3}));

        System.out.printf("""
                            ---
                            Case 3:
                            input: colors = [0,1]
                            output:
                            
                            """);
        System.out.println(maxDistance(new int[] {0,1}));
    }

    /**
     * Smart solution O(n)
     * @param colors
     * @return
     */
    public static int maxDistance(int[] colors) {
        int maxDist = 0;
        int firstColor = colors[0];
        for (int i = colors.length - 1; i >= 0; i--) {
            if (colors[i] != firstColor &&
                    i > maxDist) {

                maxDist = i;
                break;
            }
        }
        firstColor = colors[colors.length - 1];
        for (int i = 0; i < colors.length; i++) {
            if (colors[i] != firstColor &&
                    colors.length - 1 - i > maxDist) {

                maxDist = colors.length - 1 - i;
                break;
            }
        }
        return maxDist;
    }

     /**
     * Brute force solution O(n^2)
     * @param colors
     * @return
     */
     /*
     public static int maxDistance(int[] colors) {
        int[] maxDist = {0};
        Map<Integer, int[]> nearFarHouses = new HashMap();
        int[] nearFarValues = null;
        for (int i = 0; i < colors.length; i++) {
            if (!nearFarHouses.containsKey(colors[i])) {
                nearFarHouses.put(colors[i], new int[]{i, i});
            } else {
                nearFarValues = nearFarHouses.get(colors[i]);
                if (i > nearFarValues[1]) {
                    nearFarValues[1] = i;
                }
            }
        }
        nearFarHouses.forEach((colorA, nearFarA) -> {
            nearFarHouses.forEach((colorB, nearFarB) -> {
                if (colorB != colorA) {
                    int aDist = Math.abs(nearFarB[1] - nearFarA[0]);
                    int bDist = Math.abs(nearFarA[1] - nearFarB[0]);
                    maxDist[0] = aDist > maxDist[0] ? aDist : maxDist[0];
                    maxDist[0] = bDist > maxDist[0] ? bDist : maxDist[0];
                }
            });
        });
        return maxDist[0];
    }
    */
}