package strStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of distinct integers, return all possible subsets.
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * If S = [1,2,3], a solution is:
 * [
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
 * ]
 *
 */
public class Subset {
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */

    public static void main(String args[]) {
        new Subset().test();
    }

    private void test() {
        int[] nums = {1, 2, 3};

        List<List<Integer>> subSetList = new ArrayList<>();
        subSetList = subsets(nums);
        for (List<Integer> subSets: subSetList) {
            System.out.println(subSets);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {

        // write your code here
        List<List<Integer>> subSetsList = new ArrayList<>();
        List<Integer> subSet = new ArrayList<>();

        if(nums == null) {
            return subSetsList;
        }
        //add blank one
        subSetsList.add(subSet);
        //sort it firstly
        Arrays.sort(nums);

        addSubsetsFromIndex(0, nums, subSet,subSetsList);
        return subSetsList;
    }

    private void addSubsetsFromIndex(int i, int[] nums, List<Integer> subset, List<List<Integer>> subSetsList) {
        int j;
        for (j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            subSetsList.add(new ArrayList<>(subset));

            addSubsetsFromIndex(j+1,nums,subset,subSetsList);
            subset.remove(subset.size()-1);
        }
    }


}
