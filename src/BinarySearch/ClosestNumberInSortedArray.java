package BinarySearch;

/**
 * Given a target number and an integer array A sorted in ascending order, find the
 * index i in A such that A[i] is closest to the given target.
 * Return -1 if there is no element in the array.
 * There can be duplicate elements in the array, and we can return any of the indices with
 * same value.
 * Example:
 * Given [1, 2, 3] and target = 2, return 1.
 * Given [1, 4, 6] and target = 3, return 1.
 * Given [1, 4, 6] and target = 5, return 1 or 2.
 * Given [1, 3, 3, 4] and target = 2, return 0 or 1 or 2.
 */
public class ClosestNumberInSortedArray {
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        //exception
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if ((target - A[start]) < (A[end] - target)) {
            return start;
        }
        return end;
    }
}
