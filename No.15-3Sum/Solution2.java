import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* this runtime is O(n^2)
 * idea is very simple sum = nums[i] + nums[j] + nums[last]; sum==0/sum<0/sum>0 change the index
 * ！important: the last index should be refresh when i++! 
 * */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <3) return result;
        Arrays.sort(nums);

        for (int i = 0;i<= nums.length-3;i++) {
            if (nums[i] > 0) break;
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1,last = nums.length-1;j<=last-1;){
                if (j > i+1 && nums[j]==nums[j-1]){j++;continue;}
                int sum = nums[i] + nums[j] + nums[last];
                if (sum > 0) {
                    last--;
                }else if (sum == 0) {
//                    List<Integer> Result = new ArrayList<>();
//                    Result.add(nums[i]);Result.add(nums[j]);Result.add(nums[last]);
//                    result.add(Result);
                    result.add(Arrays.asList(nums[i],nums[j],nums[last]));
//                    This method also provides a convenient way to create a fixed-size list initialized to contain several elements:
                    // is faster than add for 3 times
                    j++;
                    last--;
                }else {
                    j++;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        Solution2 so2 = new Solution2();
        System.out.println(so2.threeSum(nums));
    }
}

