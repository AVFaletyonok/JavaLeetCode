public class Solution {
    public static void main(String[] args) {
        int complNumber = findComplement(5);
        System.out.println("The complement of 5 is : " + complNumber);

        complNumber = findComplement(1);
        System.out.println("The complement of 1 is : " + complNumber);
    }

    private static int findComplement(int num) {
        int bit = 0;
        int index = 31;
        while (index >= 0 && bit == 0) {
            index--;
            bit = (num >> index) & 1;
        }
        for (; index >= 0; index--) {
            bit = (num >> index) & 1;
            if (bit == 1) {
                num = num & ~(1 << index);
            } else {
                num = num | (1 << index);
            }
        }
        return num;
    }
}