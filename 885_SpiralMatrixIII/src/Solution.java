
public class Solution {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int[][] matrix = spiralMatrixIII(3, 3, 0, 0);
        printMatrix(matrix);
        System.out.printf("\n");
        matrix = spiralMatrixIII(1, 4, 0, 0);
        printMatrix(matrix);
        System.out.printf("\n");
        matrix = spiralMatrixIII(5, 6, 1, 4);
        printMatrix(matrix);
        System.out.printf("\n");
        matrix = spiralMatrixIII(3, 3, 2, 2);
        printMatrix(matrix);
    }

    private static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] spiralMatrix = new int[rows][cols];
        int maxIndex = rows * cols;
        int[][] coordinateMatrix = new int[maxIndex][2];

        int index = 1;
        spiralMatrix[rStart][cStart] = index++;
        coordinateMatrix[0][0] = rStart;
        coordinateMatrix[0][1] = cStart;

        int vSpiralCount = Math.max(rows - rStart - 1, rStart);
        int gSpiralCount = Math.max(cols - cStart - 1, cStart);
        int spiralCount = Math.max(vSpiralCount, gSpiralCount);

        for (int k = 1; k <= spiralCount && index <= maxIndex; k++) {
            int iCurIndex = 0;
            int jCurIndex = cStart + k;
            for (iCurIndex = rStart - k + 1; iCurIndex <= rStart + k; iCurIndex++) {
                if (0 <= iCurIndex && iCurIndex < rows && 0 <= jCurIndex && jCurIndex < cols) {
                    coordinateMatrix[index - 1][0] = iCurIndex;
                    coordinateMatrix[index - 1][1] = jCurIndex;
                    spiralMatrix[iCurIndex][jCurIndex] = index++;
                }
            }
            iCurIndex = rStart + k;
            for (jCurIndex = cStart + k - 1; jCurIndex >= cStart - k && index <= maxIndex; jCurIndex--) {
                if (0 <= iCurIndex && iCurIndex < rows && 0 <= jCurIndex && jCurIndex < cols) {
                    coordinateMatrix[index - 1][0] = iCurIndex;
                    coordinateMatrix[index - 1][1] = jCurIndex;
                    spiralMatrix[iCurIndex][jCurIndex] = index++;
                }
            }
            jCurIndex = cStart - k;
            for (iCurIndex = rStart + k - 1; iCurIndex >= rStart - k && index <= maxIndex; iCurIndex--) {
                if (0 <= iCurIndex && iCurIndex < rows && 0 <= jCurIndex && jCurIndex < cols) {
                    coordinateMatrix[index - 1][0] = iCurIndex;
                    coordinateMatrix[index - 1][1] = jCurIndex;
                    spiralMatrix[iCurIndex][jCurIndex] = index++;
                }
            }
            iCurIndex = rStart - k;
            for (jCurIndex = cStart - k + 1; jCurIndex <= cStart + k && index <= maxIndex; jCurIndex++) {
                if (0 <= iCurIndex && iCurIndex < rows && 0 <= jCurIndex && jCurIndex < cols) {
                    coordinateMatrix[index - 1][0] = iCurIndex;
                    coordinateMatrix[index - 1][1] = jCurIndex;
                    spiralMatrix[iCurIndex][jCurIndex] = index++;
                }
            }
        }
        printMatrix(spiralMatrix);

        return coordinateMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d", matrix[i][j]);
                if (j < n - 1) System.out.printf(" ");
            }
            System.out.printf("\n");
        }
    }
}