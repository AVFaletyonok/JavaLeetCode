import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        timePoints1.stream().forEach(s -> System.out.println(s + " "));
        System.out.println(findMinDifference(timePoints1));

        List<String> timePoints2 = Arrays.asList("00:00","23:59","00:00");
        timePoints2.stream().forEach(s -> System.out.println(s + " "));
        System.out.println(findMinDifference(timePoints2));
    }

    public static int findMinDifference(List<String> timePoints) {
        return 0;
    }
}