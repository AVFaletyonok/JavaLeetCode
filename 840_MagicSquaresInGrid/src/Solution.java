public class Solution {
    public static void main(String[] args) {
        int[][] magicMatrix = new int[][] {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        System.out.println(numMagicSquaresInside(magicMatrix));

        int[][] wrongMatrix = new int[][] {{8}};
        System.out.println(numMagicSquaresInside(wrongMatrix));

        int[][] magicMatrix5 = new int[][] {{5,5,5},{5,5,5},{5,5,5}};
        System.out.println(numMagicSquaresInside(magicMatrix5));
    }

    private static int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int countMagic = 0;
        if (m >= 3 && n >= 3) {
            for (int i = 0; i <= m - 3; i++) {
                for (int j = 0; j <= n - 3; j++) {
                    countMagic += isMagic(grid, i, j);
                }
            }
        }
        return countMagic;
    }

    private static int isMagic(int[][] grid, int iStart, int jStart) {
        int result = 1;
        int iMax = iStart + 3;
        int jMax = jStart + 3;
        int expectSum = grid[iStart][jStart] + grid[iStart + 1][jStart + 1] + grid[iStart + 2][jStart + 2];
        if (expectSum != grid[iStart + 2][jStart] + grid[iStart + 1][jStart + 1] + grid[iStart][jStart + 2])
            result = 0;
        // rows
        for (int i = iStart; i < iMax && result == 1; i++) {
            int curSum = 0;
            for (int j = jStart; j < jMax; j++) {
                curSum += grid[i][j];
            }
            if (curSum != expectSum) result = 0;
        }
        // columns
        for (int j = jStart; j < jMax && result == 1; j++) {
            int curSum = 0;
            for (int i = iStart; i < iMax; i++) {
                curSum += grid[i][j];
            }
            if (curSum != expectSum) result = 0;
        }
        // check are there numbers different
        int[] buf = new int[10];
        for (int i = iStart; i < iMax && result == 1; i++) {
            for (int j = jStart; j < jMax && result == 1; j++) {
                int numb = grid[i][j];
                if (0 < numb && numb < 10 && buf[numb] == 0) {
                    buf[numb] = 1;
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }
}