package problemsolvingtechniques;

import java.util.Arrays;

/*
When an array consists of integers where every element
appears k times except for one, we can use below method to
find that one number
*/
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 4, 1, 2, 1, 3, 2, 3};
        int[] nums2 = new int[]{8, 9, 4, 6, 4, 9, 7, 8, 6};

        System.out.println(String.format("The only number which appeared once from the array %s is: %d",
                Arrays.toString(nums1), getSingleNumber(nums1)));
        System.out.println(String.format("The only number which appeared once from the array %s is: %d",
                Arrays.toString(nums2), getSingleNumber(nums2)));
    }

    private static int getSingleNumber(int[] nums) {
        int distinctNumber = 0;
        for (int num : nums) {
            distinctNumber ^= num;
        }

        return distinctNumber;
    }
}
