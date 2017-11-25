package BinarySearch;

/**
 * Given a target number and an integer array sorted in ascending order. Find the
 * total number of occurrences of target in the array.
 * Example:
 * Given [1, 3, 3, 4, 5] and target = 3, return 2.
 * Given [2, 2, 3, 4, 6] and target = 4, return 1.
 * Given [1, 2, 3, 4, 5] and target = 6, return 0.
 *
 */
public class TotalOccurrenceOfTarget {
    /*
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        //exception
        if (A == null || A.length == 0) {
            return 0;
        }
        int firstPosition = findFirstPosition(A, target);
        int lastPosition = findLastPosition(A, target);

        if (firstPosition != -1 && lastPosition != -1) {
            return lastPosition - firstPosition + 1;
        } else {
            return 0;
        }
    }

    private int findFirstPosition(int[] A, int target) {
        //exception
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

    private int findLastPosition(int[] A, int target) {
        //exception
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[end] == target) {
            return end;
        }
        if (A[start] == target) {
            return start;
        }
        return -1;
    }
}
