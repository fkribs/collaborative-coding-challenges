// Given an integer array nums, find the contiguous subarray 
// (containing at least one number) 
// which has the largest sum and return its sum.

// Example:
// Input: [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

// Follow up:
// If you have figured out the O(n) solution,
// try coding another solution using the divide and conquer approach,
// which is more subtle.

class Program {
    public static void main(String[] args) {
        int[] array = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Forrest: " + ForrestSolution(array));
        System.out.println("Kevin: " + KevinSolution(array));
    }

    public static int ForrestSolution(int[] nums){
        int res = 0;
        int subarraySize = 1;
        for (int i = 0; i < nums.length; i++){
            int currentVal = nums[i];
            if (currentVal >= res / subarraySize){
                res += currentVal;
                subarraySize++;
            }else{
                res = 0;
                subarraySize = 1;
            }
        }
        return res;
    }

    public static int KevinSolution(int[] nums){
        return -1;
    }
}