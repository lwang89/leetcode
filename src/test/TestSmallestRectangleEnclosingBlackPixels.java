package test;

public class TestSmallestRectangleEnclosingBlackPixels {
    public static void main(String[] args) {
        new TestSmallestRectangleEnclosingBlackPixels().test();
    }

    private void test() {
        char[][] image = new char[3][4];
        image[0][0] = '0';
        image[0][1] = '0';
        image[0][2] = '1';
        image[0][3] = '0';
        image[1][0] = '0';
        image[1][1] = '1';
        image[1][2] = '1';
        image[1][3] = '0';
        image[2][0] = '0';
        image[2][1] = '1';
        image[2][2] = '0';
        image[2][3] = '0';
        System.out.println(image.length);

        int x = 0;
        int y = 2;

        int left,right,top,down;
        left = findLeft(image, y);
        right = findRight(image, y);
        top = findTop(image, x);
        down = findDown(image, x);
        System.out.println("left is " + left);
        System.out.println("right is : " + right);
        System.out.println("top is : " + top);
        System.out.println("down is : " + down);
        System.out.println((right - left + 1)*(down - top + 1));


//        for (int i = 0; i < image.length ; i++) {
//            for (int j = 0; j < image[0].length; j++) {
//                System.out.println(image[i][j]);
//            }
//            System.out.println("\n");
//        }



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

//        System.out.println("start is : " + start);
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
        System.out.println("111111start is " + start);
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
//        System.out.println("1111111 end is :" + end);
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
        System.out.println("end is : " + end);
        //at last, we need to check the end point
        for (int i = 0; i < image[0].length; i++) {
            if (image[end][i] == '1') {
                return end;
            }
        }
        return start;
    }

}
