public class Solution {  // faster than 100%, space less than 100% 
    public boolean isOneBitCharacter(int[] bits) {
        int index = bits.length-2;
        int numOf1 = 0;
        while (index>=0) {
            if (bits[index]==0) {
                return (numOf1)/2==0;
            }
            else {
                numOf1 +=1;
                index -= 1;

            }
        }
        return numOf1 / 2 == 0;
    }

    public static void main(String[] args) {
        Solution so = new Solution();
        int[] bits = new int[]{1,0,0};
        System.out.println(so.isOneBitCharacter(bits));
    }
}
