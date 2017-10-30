package strStr;

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     *
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    private static final int R = 31;
    private static final int Q = 997;


    public static void main(String args[]) {
        new Solution().test();
    }

    public int strStr(String source, String target) {
        // write your code here
        //null

        if (source == null || target == null) {
            return -1;
        }
        //source.length() < target.length()
        if (source.length() < target.length()) {
            return -1;
        }
        int j;
        for (int i = 0; i < source.length() - target.length(); i++) {

            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }

    void test() {
        String source = "kkabcdabcdefg";
        String target = "bcd";
        System.out.println(strStr(source, target));
    }
}