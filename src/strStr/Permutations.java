package strStr;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of numbers, return all possible permutations.
 * You can assume that there is no duplicate numbers in the list.
 * For nums = [1,2,3], the permutations are:
 * [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class Permutations {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */

    public static void main(String args[]) {
        new Permutations().test();
    }
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<Integer> permutation = new ArrayList<>();
        List<List<Integer>> permutationList = new ArrayList<>();

        if (nums == null ) {
            permutationList.add(new ArrayList<>(permutation));
            return permutationList;
        }

        int[] tempNums = nums;
        if (permutation.size() == nums.length) {
            permutationList.add(new ArrayList<>(permutation));
        } else {
            addPermutationFromIndex( nums, permutation, permutationList);
        }

        return permutationList;
    }

    public void addPermutationFromIndex( int[] nums, List<Integer> permutation, List<List<Integer>> permutationList) {

        for (int j = 0; j < nums.length; j ++) {
            if (!permutation.contains(nums[j])) {
                permutation.add(nums[j]);

                if (permutation.size() == nums.length) {
                    permutationList.add(new ArrayList<>(permutation));
                } else {
                    addPermutationFromIndex( nums, permutation, permutationList);
                }
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    private void test() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> subSetList = new ArrayList<>();
        subSetList = permute(nums);
        for (List<Integer> subSets: subSetList) {
            System.out.println(subSets);
        }
    }
}
