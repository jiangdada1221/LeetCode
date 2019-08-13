public class Solution2 {
    /*
    *basic idea is that: first choosing 2 numbers(in order -12)
    perform 4 operations and then!: see these two numbers as a new single number!
    then with 3 'numbers' left have 6 * 4 possibilities
    2 numbers left have 2*4  in total has 9216 possibilities.
    */
    public boolean judgePoint24(int[] nums) {
        if (nums.length == 0) return false;
        float[] numsFloat = new float[4];
        for (int i = 0; i <= 3; i++) {
            numsFloat[i] = (float) nums[i];
        }
        return helper(numsFloat);
    }

    private boolean helper(float[] nums) {  // 排列组合相当于多次遍历
        if (nums.length == 1) return Math.abs(nums[0] - 24) < 1e-3;    // 1e-6 is not enough
        int length = nums.length;
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= length - 1; j++) {
                if (i == j || j < i) continue;       // j<i can reduce redundency '+' and '*' are mutate
                else {                               // this reduce the runtime to about 1/3
                    float[] newNums = new float[length - 1];
                    int h = 0;
                    for (int k = 0; k <= length - 1; k++) {
                        if (k != j && k != i) {
                            newNums[h] = nums[k];
                            h++;
                        }
                    }
                    newNums[newNums.length - 1] = nums[i] + nums[j];
                    if (helper(newNums)) return true;
                    newNums[newNums.length - 1] = nums[i] - nums[j];
                    if (helper(newNums)) return true;
                    newNums[newNums.length - 1] = nums[i] * nums[j];
                    if (helper(newNums)) return true;
                    if (nums[j] != 0) {
                        newNums[newNums.length - 1] = nums[i] / nums[j];
                        if (helper(newNums)) return true;
                    }
                    newNums[newNums.length - 1] = nums[j] - nums[i];
                    if (helper(newNums)) return true;
                    if (nums[i] != 0) {
                        newNums[newNums.length - 1] = nums[j] / nums[i];
                        if (helper(newNums)) return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 8, 3, 8};
        Solution2 so2 = new Solution2();
        System.out.println(so2.judgePoint24(test));

    }
}
