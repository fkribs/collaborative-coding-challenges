import java.util.Arrays;

// Given an array nums, write a function to move all 0's 
// to the end of it while maintaining the relative order of the non-zero elements.

// Example:
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

class Program {
    public static void main(String[] args) {
        int[] array1 = new int[]{0, 1, 0, 3, 12};
        int[] array2 = new int[]{0, 1, 0, 3, 12};
    
        ForrestSolution(array1);
        System.out.println(Arrays.toString(array1));
        KevinSolution(array2);
        System.out.println(Arrays.toString(array2));

    }

    public static void ForrestSolution(int[] nums) {
        // int numZeroes = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0)
                continue;
            for (int i2 = i; i2 < length - 1; i2++) {
                int temp = nums[i2];
                nums[i2] = nums[i2 + 1];
                nums[i2 + 1] = temp;
            }
        }
    }

        // int[] array1 = new int[] { 0, 1, 1, 0, 3, 12, 15, 15};
        // 0, 1, 1, 0, 3, 12, 15, 15
        // 1, 0, 1, 0, 3, 12, 15, 15
        // 1, 1, 0, 0, 3, 12, 15, 15
        // 1, 1, 3, 0, 0, 12, 15, 15
        // 1, 1, 3, 12, 0, 0, 15, 15
        // 1, 1, 3, 12, 15, 0, 0, 15
        // 1, 1, 3, 12, 15, 0, 0, 15
        // 1, 1, 3, 12, 15, 15, 0, 0

    public static void ForrestSolution2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0)
                continue;
            int numZeroes = 1;
            for (int i2 = i; i2 < length - numZeroes; i2++) {
                // System.out.println("index:\t" + i2);
                int next = nums[i2 + numZeroes];
                // System.out.println("next:\t" + next);
                if (next == 0) {
                    numZeroes++;
                    i2--;
                    continue;
                }
                // System.out.println("numZeroes:\t" + numZeroes + "\n");
                int temp = nums[i2];
                nums[i2] = nums[i2 + numZeroes];
                nums[i2 + numZeroes] = temp;
                // System.out.println(Arrays.toString(nums));
            }
        }
    }

    public static void KevinSolution(int[] nums){
        int left = 0;
        int temp;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                left++;
            }
        }
    }


}