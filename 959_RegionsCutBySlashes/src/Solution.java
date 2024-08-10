import java.awt.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        System.out.println(" /|\n  |\n--");
        int curCount = regionsBySlashes(new String[] {" /", "  "});
        System.out.println("curCount = " + curCount);

        System.out.println("\n/\\|\n\\/|\n--");
        curCount = regionsBySlashes(new String[] {"/\\", "\\/"});
        System.out.println("curCount = " + curCount);
    }

    private static int regionsBySlashes(String[] grid) {
        int[][] extendedGrid = createExtendedGrid(grid);
        printMatrix(extendedGrid);

        HashSet<Point> visitedCoordinates = new HashSet<>();
        int n = extendedGrid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (extendedGrid[i][j] == 0 && !visitedCoordinates.contains(new Point(i, j))) {
                    visitRegion(extendedGrid, visitedCoordinates, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void visitRegion(int[][] grid, HashSet<Point> visitedCoordinates, int x, int y) {
        ArrayDeque<Point> path = new ArrayDeque();
        path.add(new Point(x, y));
        Point[] diractions = new Point[]{new Point(-1, 0), new Point(1, 0),
                new Point(0, -1), new Point(0, 1)};
        int nDir = diractions.length;
        int nGrid = grid.length;

        while (!path.isEmpty()) {
            Point curPos = path.pop();

            for (int i = 0; i < nDir; i++) {
                int curX = curPos.x + diractions[i].x;
                int curY = curPos.y + diractions[i].y;
                if (0 <= curX && curX < nGrid && 0 <= curY && curY < nGrid &&
                    grid[curX][curY] == 0 && !visitedCoordinates.contains(new Point(curX, curY))) {

                    visitedCoordinates.add(new Point(curX, curY));
                    path.add(new Point(curX, curY));
                }
            }
        }

    }

    private static int[][] createExtendedGrid(String[] str) {
        int n = str.length;
        int[][] grid = new int[3 * n][3 * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                switch (str[i].charAt(j)) {
                    case  '/':
                        grid[3 * i][3 * j + 2] = 1;
                        grid[3 * i + 1][3 * j + 1] = 1;
                        grid[3 * i + 2][3 * j] = 1;
                        break;
                    case '\\':
                        grid[3 * i][3 * j] = 1;
                        grid[3 * i + 1][3 * j + 1] = 1;
                        grid[3 * i + 2][3 * j + 2] = 1;
                }
            }
        }
        return grid;
    }

    private static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.printf("\n");
        }
    }
}