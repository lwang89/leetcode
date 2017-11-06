package BinarySearch;


/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Example:
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 */
public class SearchInrotatedSortedArray {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */

    public int search1(int[] A, int target) {
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
            }else if (A[mid] > A[start]) {
                if (A[start] <= target && target < A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] < target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
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
    public int search2(int[] A, int target) {
        // write your code here
        //exception
        if (A == null || A.length == 0) {
            return -1;
        }
        //A.length == 1
        if (A.length ==1) {
            if (A[0] == target) {
                return 0;
            }
        }
        //check it is a RSA, or a SA
        if (A[0] < A[A.length - 1]) {
            return findTarget(A, 0, A.length - 1, target);
        } else {
            int minIndex = findMinIndex(A);

            if (target >= A[0] && target <= A[minIndex - 1]) {
                return findTarget(A, 0, minIndex - 1, target);
            } else if (target >= A[minIndex] && target <= A[A.length - 1]) {
                return findTarget(A, minIndex, A.length - 1, target);
            }
        }
        return -1;
    }

    private int findTarget(int[] nums, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    private int findMinIndex(int[] A) {
        //exception
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] < A[end]) {
            return start;
        }
        return end;
    }
}
