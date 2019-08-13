import java.text.DecimalFormat;

class Solution {
    public boolean judgePoint24(int[] nums) {
//        return helper(nums,24);
        for (int i = 0;i<=3;i++) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            if (helper(nums,24)) return true;
        }
        return false;
    }

    private boolean helper(int[] nums, double goal) {
        if (nums.length == 1) {
            if (nums[0] == goal) return true;
            return false;
        }
        int length = nums.length;
        for (int k = 0;k<=length-1;k++){
            int temp = nums[0];
            nums[0] = nums[k];
            nums[k] = temp;
            int[] nums3 = new int[length-1];
            for (int i = 0;i<=length-2;i++) {
                nums3[i] = nums[i+1];
            }
//        if (helper(nums3,goal*1.0/nums[0])) return true;
//        if (helper(nums3,nums[0]/goal)) return true;
//        if (helper(nums3,Math.abs(goal-nums[0]))) return true;
//        if (helper(nums3,Math.abs(nums[0]-goal))) return true;
//        if (helper(nums3,goal* nums[0])) return true;
            boolean n3 = helper2(nums3,goal,(double)(nums[0]));
            if (n3) return true;

            if (length==2) return false;

            if (length == 4) {
                for (int i = 1; i <= 2; i++) {
                    int a = 3 - i;
                    int[] nums2 = new int[]{nums[a], nums[3]};
                    if (helper2(nums2,goal,nums[0]+nums[i])) return true;
                    if (helper2(nums2,goal,nums[0]*nums[i])) return true;
                    if (helper2(nums2,goal,Math.abs(nums[0]-nums[i]))) return true;
                    if (helper2(nums2,goal,nums[0]*1.0/nums[i])) return true;
                    if (helper2(nums2,goal,nums[i]*1.0/nums[0])) return true;
                }
                int[] nums2 = new int[]{nums[1],nums[2]};
                if (helper2(nums2,goal,nums[0]+nums[3])) return true;
                if (helper2(nums2,goal,nums[0]*nums[3])) return true;
                if (helper2(nums2,goal,Math.abs(nums[0]-nums[3]))) return true;
                if (helper2(nums2,goal,nums[0]*1.0/nums[3])) return true;
                if (helper2(nums2,goal,nums[3]*1.0/nums[0])) return true;
            }

            if (length == 3) {
                for (int i = 1;i<=2;i++) {
                    int a = 3-i;
                    int[] nums1 = new int[]{nums[a]};
                    if (helper2(nums1,goal,nums[0]+nums[i])) return true;
                    if (helper2(nums1,goal,nums[0]*nums[i])) return true;
                    if (helper2(nums1,goal,Math.abs(nums[0]-nums[i]))) return true;
                    if (helper2(nums1,goal,nums[0]*1.0/nums[i])) return true;
                    if (helper2(nums1,goal,nums[i]*1.0/nums[0])) return true;
                }
            }}
        return false;
    }

    private boolean helper2(int[] nums, double goal,double value) {
        DecimalFormat f = new DecimalFormat("##.00000");
        if (value != 0) {
            if (helper(nums,goal*1.0/value)) return true;
            if (helper(nums,value/goal)) return true;
            if (helper(nums,Double.parseDouble(f.format(Math.abs(goal-value))))) return true;
            if (helper(nums,goal+value)) return true;
            if (helper(nums,goal* value)) return true;}
        else {
            if (helper(nums,Math.abs(goal-value))) return true;
            if (helper(nums,Math.abs(value-goal))) return true;
        }
        return false;
    }

}
