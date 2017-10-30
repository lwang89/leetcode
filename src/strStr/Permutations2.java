package strStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * For numbers [1,2,2] the unique permutations are:
 * [
 [1,2,2],
 [2,1,2],
 [2,2,1]
 ]
 */
public class Permutations2 {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public static void main(String args[]) {
        new Permutations2().test();
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> permutationList = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        //exception
        if(nums == null ) {
            permutationList.add(new ArrayList<>(permutation));
            return permutationList;
        }

        Arrays.sort(nums);
        if (permutation.size() == nums.length) {
            permutationList.add(new ArrayList<>(permutation));
        } else {
            for (int i = 0; i < used.length ; i++) {
                used[i] = false;
            }
            addPermutation(used,nums, permutation, permutationList);
        }
        //permutation.remove(permutation.size() - 1);


        return permutationList;
    }

    private void addPermutation(boolean[] used, int[] nums, List<Integer> permutation, List<List<Integer>> permutationList) {

        for (int j = 0; j < nums.length; j++) {
            if(!used[j]) {
                permutation.add(nums[j]);
                used[j] = true;
                if ((permutation.size() == nums.length) && (!permutationList.contains(permutation))) {
                    permutationList.add(new ArrayList<>(permutation));
                } else {
                    addPermutation(used, nums, permutation, permutationList);
                }
                permutation.remove(permutation.size() - 1);
                used[j] =false;
            }
        }
    }



    private void test() {
        int[] nums = {-1,2,-1,2,1,-1,2,1};

        List<List<Integer>> subSetList = new ArrayList<>();
        subSetList = permuteUnique(nums);
        for (List<Integer> subSets: subSetList) {
            System.out.println(subSets);
        }
    }
}
