import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    private static final int MIN_IN_DAY = 1440;

    public static void main(String[] args) {
        List<String> timePoints1 = Arrays.asList("23:59", "00:00");
        timePoints1.stream().forEach(s -> System.out.print(s + " "));
        System.out.printf("\nMin min difference: %d\n\n", findMinDifference(timePoints1));

        List<String> timePoints2 = Arrays.asList("00:00","23:59","00:00");
        timePoints2.stream().forEach(s -> System.out.print(s + " "));
        System.out.printf("\nMin min difference : %d", findMinDifference(timePoints2));
    }

    public static int findMinDifference(List<String> timePoints) {
        List<Integer> timeDifference = timePoints.stream()
                .map(s -> Integer.parseInt(s.substring(0, 2)) * 60 +
                        Integer.parseInt(s.substring(3)))
                .sorted()
                .collect(Collectors.toList());

        int minDiff = Integer.MAX_VALUE;
        int size = timeDifference.size();
        for (int i = 0; i < size; i++) {
            int j = (i + 1) % size;
            int t1 = timeDifference.get(i);
            int t2 = timeDifference.get(j);
            int curDiff = t2 - t1;
            if (t2 < t1) curDiff = MIN_IN_DAY + t2 - t1;
            if (curDiff < minDiff) minDiff = curDiff;
        }
        return minDiff;
    }
}