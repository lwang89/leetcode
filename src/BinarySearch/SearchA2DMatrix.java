package BinarySearch;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Examples:
 * Consider the following matrix:
 * [
 *    [1, 3, 5, 7],
 *    [10, 11, 16, 20],
 *    [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class SearchA2DMatrix {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        //exception
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        //only only one line
        if (matrix.length == 1) {
            return findTargetInRow(matrix, target, 0);
        } else {
            int line = findLineOfTarget(matrix,target);
            return findTargetInRow(matrix, target, line);
        }
    }

    private int findLineOfTarget(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] < target && target < matrix[mid][matrix[mid].length - 1]) {
                return mid;
            }
            if (target < matrix[mid][0]) {
                end = mid;
            }
            if (target > matrix[mid][matrix[mid].length - 1]) {
                start = mid;
            }
        }
        if (matrix[start][0] <= target && target <= matrix[start][matrix[start].length - 1]) {
            return start;
        }
        if (matrix[end][0] <= target && target <= matrix[end][matrix[end].length - 1]) {
            return end;
        }
        return -1;
    }

    private boolean findTargetInRow(int[][] matrix, int target, int row) {
        //exception
        if (row == -1 || row > matrix.length - 1) {
            return false;
        }
        int start = 0;
        int end = matrix[row].length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target) {
            return true;
        }
        return false;
    }
}
