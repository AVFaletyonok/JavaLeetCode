import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[][] edges1 = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        Arrays.stream(edges1).forEach(edge -> System.out.println(edge[0] + " - " + edge[1]));
        System.out.println("There is/are valid path(s) from source to destination : " +
                validPath(3, edges1, 0, 2));

        int[][] edges2 = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        Arrays.stream(edges2).forEach(edge -> System.out.println(edge[0] + " - " + edge[1]));
        System.out.println("There is/are valid path(s) from source to destination : " +
                validPath(6, edges2, 0, 5));

        int[][] edges3 = new int[][]{{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4},
                {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}};
        Arrays.stream(edges3).forEach(edge -> System.out.println(edge[0] + " - " + edge[1]));
        System.out.println("There is/are valid path(s) from source to destination : " +
                validPath(10, edges3, 5, 9));
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        return false;
    }
}