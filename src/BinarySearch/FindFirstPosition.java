package BinarySearch;


/**
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 * If the target number does not exist in the array, return -1.
 * Example
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 */
public class FindFirstPosition {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        //exception
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        return -1;
    }
}
