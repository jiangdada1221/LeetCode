import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* this runtime is O(n^2log(n)) slightly faster than O(n^3)
* idea is iterate over(n^2) then use binarySearch the third element
* */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
//        int start = 0;
//        int end = nums.length-1;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0;i<=nums.length-3;i++) {
            if (i>=1 && nums[i] == nums[i-1]) continue;
            for (int j = i+1;j<=nums.length-2;j++) {
                if (j > i+1 && nums[j]==nums[j-1]) continue;
                int goal = 0-(nums[i] + nums[j]);
                int index = binarySearch(j+1,nums.length-1,nums,goal);
                if (index == -1) continue;
                else {
                    List<Integer> Result = new ArrayList<>();
                    Result.add(nums[i]);Result.add(nums[j]);Result.add(nums[index]);
                    result.add(Result);
                }
            }
        }
        return result;
    }

    private int binarySearch(int start,int end, int[] nums,int goal){

        if (nums[start] == goal) return start;
        if (nums[end] == goal) return end;
        if ((end - start)<2) return -1;
        int middle = (end - start)/2 + start;
        if (goal == nums[middle]) return middle;
        else if (nums[middle] > goal) {
            return binarySearch(start,middle,nums,goal);
        } else {
            return binarySearch(middle,end,nums,goal);
        }
    }

    public static void main(String[] args) {
      int[] nums = new int[]{0,0,0};
      Solution so = new Solution();
      System.out.println(so.threeSum(nums));
    }
}
