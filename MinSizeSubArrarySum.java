import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

// Given an array of n positive integers and a positive integer s, 
// find the minimal length of a contiguous subarray of which
// the sum ≥ s. If there isn't one, return 0 instead.

// Example: 
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal 
// length under the problem constraint.

class MinSizeSubArraySum {
    public static int minSum = 7;
    public static void main(String[] args) {
        System.out.println("MaxStockProfit Test");
        int start = 5;
        double percentIncrease = 1.00;
        int max = 500_000_000;
        for (int i = start; i < max; i = (int) (i * (1 + percentIncrease))) {
            System.out.println("\n\tTesting at '" + i + "' items.");
            if (max > 100)
                Test(i);
            else
                Test(i, true);
        }

    }

    public static void ForrestSolution(int[] nums) {
        int s = minSum;
        int frontIndex = 0;
        int backIndex = 0;
        int currentTotal = 0;
        for (int i : nums) {
            if (currentTotal < s) {
                currentTotal += i;
                backIndex ++;
            } else if (currentTotal + i - nums[frontIndex] >= s) {
                currentTotal = currentTotal + i - nums[frontIndex];
                frontIndex++;
                backIndex++;
            }
            while (true) {
                if (currentTotal - nums[frontIndex] >= s) {
                    currentTotal -= nums[frontIndex];
                    frontIndex++;
                } else
                    break;
            }
        }
        int result = backIndex - frontIndex;
        if (currentTotal < s)
            result = 0;
        if (backIndex == frontIndex)
            result = 1;
        System.out.println("Forrest result: " + result);
    }

    public static void KevinSolution(int[] nums) {
        int s = minSum;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= s) {
                min = Math.min(min, (i + 1) - left);
                sum = sum - nums[left];
                left++;
            }
        }
        System.out.println("Kevin result: " + (min != Integer.MAX_VALUE ? min : 0));
    }
    private static void Test(int arraySize){
        Test(arraySize, false);
    }

    private static void Test(int arraySize, boolean printResult) {
        int[] arr = GenerateIntArray(arraySize);
        if (printResult) {
            System.out.println("Generated array:\t");
            System.out.println(Arrays.toString(arr));
        }

        int[] arrCopy = CopyArray(arr);
        String label = "Forrest";
        long elapsed = Time(MinSizeSubArraySum::ForrestSolution, arrCopy);
        System.out.println(label + ": " + elapsed + " milliseconds");
        if (printResult)
            System.out.println(Arrays.toString(arrCopy));

        arrCopy = CopyArray(arr);
        label = "Kevin";
        elapsed = Time(MinSizeSubArraySum::KevinSolution, arrCopy);
        System.out.println(label + ": " + elapsed + " milliseconds");
        if (printResult)
            System.out.println(Arrays.toString(arrCopy));
    }

    private static long Time(Consumer<int[]> c, int[] input) {
        long startTime = System.currentTimeMillis();
        c.accept(input);
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        return elapsedTime;
    }

    private static int[] GenerateIntArray(int size) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(3);
        }
        return arr;
    }

    private static int[] CopyArray(int[] arr) {
        int length = arr.length;
        int[] arr2 = new int[length];
        for (int i = 0; i < length; i++) {
            arr2[i] = arr[i];
        }
        return arr2;
    }
}