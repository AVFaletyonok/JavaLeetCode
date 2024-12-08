public class Solution {
    public static void main(String args[]) {

        int[][] matrix0 = { {1,-1},
                {-1,1} };
        int[][] matrix00 = { {1,2,3},
                {-1,-2,-3},
                {1,2,3} };

        int[][] matrix1 = { {2,9,3},
                {5,4,-4},
                {1,7,1} };

        System.out.println(maxMatrixSum(matrix0));
        System.out.println(maxMatrixSum(matrix00));
        System.out.println(maxMatrixSum(matrix1));
    }

    public static long maxMatrixSum(int[][] matrix) {
        long result = 0L;

        int negCount = 0;
        long sumNegs = 0L;
        int maxNegNum = Integer.MIN_VALUE;
        int minPosNum = Integer.MAX_VALUE;
        boolean isZero = false;

        for(int[] curRow : matrix) {
            for (int curNum : curRow) {
                if (curNum > 0) {
                    result += curNum;
                    if (curNum < minPosNum) minPosNum = curNum;
                } else if (curNum == 0) {
                    isZero = true;
                } else {
                    negCount++;
                    if (curNum > maxNegNum) maxNegNum = curNum;
                    sumNegs += curNum;
                }
            }
        }

        result -= sumNegs;
        if (negCount % 2 == 1 && isZero == false) {
            if (minPosNum < (0 - maxNegNum)) {
                result -= 2 * minPosNum;
            } else {
                result += 2* maxNegNum;
            }
        }

        return result;
    }
}