package BinarySearch;


/**
 * Find any position of a target number in a sorted array. Return -1 if target does not exist.
 * Example
  *Given [1, 2, 2, 4, 5, 5].
 For target = 2, return 1 or 2.
 For target = 5, return 4 or 5.
 For target = 6, return -1.
 */
public class FindPosition {
    /*
 * @param nums: An integer array sorted in ascending order
 * @param target: An integer
 * @return: An integer
 */
    public static void main(String args[]) {
        new FindPosition().test();
    }

    private void test() {
        int[] nums = {1, 2, 2, 4, 5, 5};
        System.out.println(findPosition(nums, 2));
        System.out.println(findPosition(nums, 5));
        System.out.println(findPosition(nums, 6));
    }

    public int findPosition(int[] nums, int target) {
        // write your code here
        //exception
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                //find any one, return it
                 return mid;
            } else if (mid < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        //finished the whlie loop

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }


        return -1;
    }
}
