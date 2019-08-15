import java.util.Arrays;
/* similar to 3Sum problem O(n^2) */
public class Solution {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0 ;
        for (int i = 0;i<= nums.length-3;i++) {

//            if (i>0 && nums[i]==nums[i-1]) continue;      the time for check is longer than just do it!
            for (int j = i+1,last = nums.length-1;j<=last-1;){
//                if (j > i+1 && nums[j]==nums[j-1]){j++;continue;}
                int sum = nums[i] + nums[j] + nums[last];
                if (sum == target) return target;
                if (Math.abs(sum - target) < diff){
                    result = sum;
                    diff = Math.abs(sum - target);
                }
                if (sum -target > 0) {

                    last--;
                }
                else {
                    j++;
                }
            }

        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,8,16,32,64,128};
        Solution so = new Solution();
        System.out.println(so.threeSumClosest(nums,82));

    }
}
