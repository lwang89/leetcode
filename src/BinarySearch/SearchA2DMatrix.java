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
    }

    private boolean findTargetInRow(int[][] matrix, int target, int row) {
        //exception
        if (row == -1 || row > matrix.length) {
            return false;
        }

        return false;
    }
}
