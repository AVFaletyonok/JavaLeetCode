
public class Solution {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");


    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] spiralMatrix = new int[rows][cols];
        int maxIndex = rows * cols;
        int index = 1;
        spiralMatrix[rStart][cStart] = index++;

        int vSpiralCount = Math.max(rows - rStart, rStart - 1);
        int gSpiralCount = Math.max(cols - cStart, cStart - 1);
        int spiralCount = Math.max(vSpiralCount, gSpiralCount);

        for (int k = 0; k < spiralCount && index <= maxIndex; k++) {

        }

        return spiralMatrix;
    }
}