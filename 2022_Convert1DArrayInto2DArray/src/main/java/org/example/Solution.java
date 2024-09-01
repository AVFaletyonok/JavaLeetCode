package org.example;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");

        int[] array1D = new int[] { 1, 2, 3, 4 };
        int[][] array2D = construct2DArray(array1D, 2, 2);
        System.out.println(Arrays.toString(array1D));
        System.out.println(Arrays.toString(array2D));
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {

        return new int[0][0];
    }
}