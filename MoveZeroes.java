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

    public static void ForrestSolution(int[] nums){

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