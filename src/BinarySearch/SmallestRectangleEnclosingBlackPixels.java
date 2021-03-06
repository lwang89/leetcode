package BinarySearch;

/**
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region. Pixels are connected
 * horizontally and vertically. Given the location (x, y) of one of the black pixels, return the
 * area of the smallest (axis-aligned) rectangle that encloses all black pixels.
 * Example:
 * For example, given the following image:
 * [
 *  "0010",
 *  "0110",
 *  "0100"
 * ]
 * and x = 0, y = 2,
 * return 6.
 */
public class SmallestRectangleEnclosingBlackPixels {
    /*
     * @param image: a binary matrix with '0' and '1'
     * @param x: the location of one of the black pixels
     * @param y: the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // write your code here
        //exception
        if (image ==null || image.length == 0) {
            return -1;
        }

        int left, right, top, down;

        left = findLeft(image, y);
        right = findRight(image, y);
        top = findTop(image, x);
        down = findDown(image, x);


        return (right - left + 1)*(down - top + 1);
    }

    private int findLeft(char[][] image, int y) {
        int start = 0;
        int end = y;
        while (start + 1 < end) {
            boolean ifBlack = false;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    ifBlack = true;
                    break;
                }
            }
            if (ifBlack) {
                end = mid;
            } else {
                start = mid;
            }
        }

        //at last, we need to check the start point
        for (int i = 0; i < image.length; i++) {
            if (image[i][start] == '1') {
                return start;
            }
        }
        return end;
    }

    private int findRight(char[][] image, int y) {
        int start = y;
        int end = image[0].length - 1;
        while (start + 1 < end) {
            boolean ifBlack = false;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < image.length; i++) {
                if (image[i][mid] == '1') {
                    ifBlack = true;
                    break;
                }
            }
            if (ifBlack) {
                start = mid;
            } else {
                end = mid;
            }
        }

        //at last, we need to check the end point
        for (int i = 0; i < image.length; i++) {
            if (image[i][end] == '1') {
                return end;
            }
        }
        return start;

    }

    private int findTop(char[][] image, int x) {
        int start = 0;
        int end = x;
        while (start + 1 < end) {
            boolean ifBlack = false;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < image[0].length; i++) {
                if (image[mid][i] == '1') {
                    ifBlack = true;
                    break;
                }
            }
            if (ifBlack) {
                end = mid;
            } else {
                start = mid;
            }
        }

        //at last, we need to check the start point
        for (int i = 0; i < image[0].length; i++) {
            if (image[start][i] == '1') {
                return start;
            }
        }
        return end;
    }

    private int findDown(char[][] image, int x) {
        int start = x;
        int end = image.length - 1;
        while (start + 1 < end) {
            boolean ifBlack = false;
            int mid = start + (end - start) / 2;
            for (int i = 0; i < image[0].length; i++) {
                if (image[mid][i] == '1') {
                    ifBlack = true;
                    break;
                }
            }
            if (ifBlack) {
                start = mid;
            } else {
                end = mid;
            }
        }

        //at last, we need to check the end point
        for (int i = 0; i < image[0].length; i++) {
            if (image[end][i] == '1') {
                return end;
            }
        }
        return start;
    }
}
