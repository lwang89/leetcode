package strStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a list of numbers that may has duplicate numbers, return all possible subsets
 * Each element in a subset must be in non-descending order.
 * The ordering between two subsets is free.
 * The ordering between two subsets is free.
 * If S = [1,2,2], a solution is:
 * [
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 */
public class Subset2 {
    /*
 * @param nums: A set of numbers.
 * @return: A list of lists. All valid subsets.
 */
    public static void main(String args[]) {
        new Subset2().test();
    }

    private void test() {
        int[] nums = {0};

        List<List<Integer>> subSetList = new ArrayList<>();
        subSetList = subsetsWithDup(nums);
        for (List<Integer> subSets: subSetList) {
            System.out.println(subSets);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        //sort it first
        Arrays.sort(nums);
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> subSetList = new ArrayList<>();

        //exception
        if (nums == null) {
            return subSetList;
        }
        //add the blank one
        subSetList.add(new ArrayList<>(subSet));
        addSubSetFromIndex(0, nums, subSet, subSetList);

        return subSetList;
    }

    public void addSubSetFromIndex(int i, int[] nums, List<Integer> subSet, List<List<Integer>> subSetList) {
        int j;
        for (j = i; j < nums.length; j++) {

            //如果和前一个数字相同，就跳过去
            if(j != i && nums[j] == nums [j - 1]) {
                continue;
            }

            subSet.add(nums[j]);
            subSetList.add(new ArrayList(subSet));
            //do it, from next one
            addSubSetFromIndex(j+1, nums, subSet, subSetList);
            subSet.remove(subSet.size() - 1);
        }
    }
}
