import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!");


    }

    private List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n = candidates.length;
        List<List<Integer>> result = new List<List<Integer>>();

        int sum = 0;
        // makeCombination(int[] candidates, int target, int sum,
        for (int i = 0; i < n; i++) {
            if (sum + candidates[i] > target) continue;
        }
    }
}