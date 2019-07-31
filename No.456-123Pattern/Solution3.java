public class Solution3 {
    /* run in theta(n^2) */
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length<3)
            return false;
        int[] small = new int[nums.length];
        int smallValue = Integer.MAX_VALUE;
        for (int i = 0;i<=nums.length-1;i++) {
            if (nums[i] < smallValue){
                smallValue = nums[i];
            }
            small[i] = smallValue;
        }


        for (int i = 1;i<=nums.length-1;i++) {
           if (nums[i] > small[i]){
               for (int j = i+1;j<=nums.length-1;j++) {
                   if (nums[j] < nums[i] && nums[j] > small[i])
                       return true;
               }
           }
    }
    return false;
    }

}
