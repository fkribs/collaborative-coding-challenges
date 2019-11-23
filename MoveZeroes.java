import java.util.Arrays;
import java.util.Random;
import java.util.function.*;;

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
        int[] arr = GenerateIntArray(5);

        int[] arr2 = CopyArray(arr);
        System.out.println(Arrays.toString(arr2));
        long elapsed = Time(Program::ForrestSolution, arr2);
        System.out.println(Arrays.toString(arr2));
        System.out.println(elapsed + " milliseconds");
        // KevinSolution(array2);
        // System.out.println(Arrays.toString(array2));

    }

    private static long Time(Consumer<int[]> c, int[] input){
        long startTime = System.currentTimeMillis();
        c.accept(input);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return elapsedTime;
    }

    private static int[] GenerateIntArray(int size){
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = rnd.nextInt(9);
        }
        return arr;
    }

    private static int[] CopyArray(int[] arr){
        int length = arr.length;
        int[] arr2 = new int[length];
        for (int i = 0; i< length; i++){
            arr2[i] = arr[i];
        }
        return arr2;
    }
    public static void ForrestSolution(int[] nums) {
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
    public static void ForrestSolution2(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0)
                continue;
            int numZeroes = 1;
            for (int i2 = i; i2 < length - numZeroes; i2++) {
                int next = nums[i2 + numZeroes];
                if (next == 0) {
                    numZeroes++;
                    i2--;
                    continue;
                }
                int temp = nums[i2];
                nums[i2] = nums[i2 + numZeroes];
                nums[i2 + numZeroes] = temp;
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