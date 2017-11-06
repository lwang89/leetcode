package BinarySearch;

/**
 * Given a mountain sequence of n integers which increase firstly and then
 * decrease, find the mountain top.
 * Example:
 * Given nums = [1, 2, 4, 8, 6, 3] return 8
 * Given nums = [10, 9, 8, 7], return 10
 */
public class MaximumNumberInMountainSequence {
    /*
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        // write your code here
        //exception
        if (nums == null || nums.length == 0) {
            return -1;
        }
        //length == 1
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] <= nums[mid] && nums[mid] >= nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (start == 0 && nums[start] >= nums[start + 1]) {
            return start;
        } else if (nums[start - 1] <= nums[start] && nums[start] >= nums[start + 1]) {
            return start;
        } else {
            return nums[end];
        }
    }
}
