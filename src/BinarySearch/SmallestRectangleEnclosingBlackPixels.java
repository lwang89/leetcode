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
    }

    private int findRight(char[][] image, int y) {
    }

    private int findTop(char[][] image, int y) {
    }

    private int findDown(char[][] image, int y) {
    }
}
