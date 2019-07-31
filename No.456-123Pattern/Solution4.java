public class Solution4 {

    /* my final approach
        this one's runtime is theta(n)  result: 2ms beats 100% java submission!

        idea is that build 2 array (small,middle) to track the smallest number BEFORE index i(name it as MIN) and the smallest
        but bigger than MIN number AFTER index i; then iterate i,
        if nums[i] > small[i] && nums[i] > middle[i] && middle[i] > small[i] (nums[i]is the biggest)
        then return true ( middle[i]>small[i] is redundent)
     */

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length<3)
            return false;
        int[] small = new int[nums.length];
        int[] middle = new int[nums.length];
        int smallValue = Integer.MAX_VALUE;
        int middleValue = Integer.MAX_VALUE;
        small[0] = smallValue;
        for (int i = 0;i<=nums.length-2;i++) {
            if (nums[i] < smallValue){
                smallValue = nums[i];
            }
            small[i+1] = smallValue;
        }

        middle[middle.length-1] = middleValue;
        for (int j = middle.length-1;j>=1;j--) {
            if (nums[j] > small[j-1] && nums[j] < middle[j  ]) {
                middleValue = nums[j];
            }
            middle[j-1] = middleValue;
        }

        for (int i = 1;i<=nums.length-2;i++) {
            if (nums[i] > small[i] && nums[i] > middle[i] && middle[i] > small[i])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3,5,0,3,4};
        Solution4 so = new Solution4();
        System.out.println(so.find132pattern(test));
    }

}
