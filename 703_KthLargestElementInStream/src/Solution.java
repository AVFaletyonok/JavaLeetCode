//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Solution {
    public static void main(String[] args) {
        KthLargest obj = new KthLargest(1, new int[0]);
        int max = obj.add(-3);
        System.out.println(max);
        max = obj.add(-2);
        System.out.println(max);
        max = obj.add(-4);
        System.out.println(max);
        max = obj.add(0);
        System.out.println(max);
        max = obj.add(4);
        System.out.println(max);

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val); */
class KthLargest {
    private int[] kLargestElements;
    private int countInitialised = 0;

    public KthLargest(int k, int[] nums) {

        if (k > 0) {
            kLargestElements = new int[k];
            for (int i = 0; i < k; i++) {
                kLargestElements[i] = Integer.MIN_VALUE;
            }

            if (nums.length > 0) {
                kLargestElements[0] = nums[0];
                countInitialised++;

                int n = nums.length;
                for (int i = 1; i < n; i++) {
                    if (nums[i] > kLargestElements[k - 1]) {
                        insertLargestElement(nums[i]);
                    }
                    countInitialised++;
                }
            }
        }
    }

    public int add(int val) {
        if (kLargestElements != null) {
            int k = kLargestElements.length;
            if (val > kLargestElements[k - 1]) {
                insertLargestElement(val);
            }
            if (countInitialised < k) countInitialised++;
            return countInitialised >= k ? kLargestElements[k - 1] : kLargestElements[countInitialised - 1];
        } else {
            throw new NullPointerException("The array of the largest elements is null.");
        }
    }

    private void insertLargestElement(int val) {
        int k = kLargestElements.length;
        if (val > kLargestElements[k - 1]) {
            for (int j = k - 1; j > 0; j--) {
                // val > kLargestElements[j] because val > kLargestElements[k - 1]
                if (val > kLargestElements[j - 1]) {
                    kLargestElements[j] = kLargestElements[j - 1];
                } else {
                    kLargestElements[j] = val;
                    break;
                }
            }
            if (val > kLargestElements[0]) kLargestElements[0] = val;
        }
    }
}