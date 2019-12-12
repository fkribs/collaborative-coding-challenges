import java.util.Arrays;
import java.util.Random;
import java.util.function.Consumer;

/*
Best Time to Buy and Sell Stock
Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(i.e., buy one and sell one share of the stock), design an algorithm to find the MAXIMUM profit.

Note that you cannot sell a stock before you buy one.
Example 1:
Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.

Example 2:
Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

class MaxStockProfit {
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

    public static int ForrestSolution(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            if (i < min) {
                min = i;
            } else {
                int currentProfit = i - min;
                if (currentProfit > profit) {
                    profit = currentProfit;
                }
            }
        }
        return profit;
    }

    public static int ForrestSolution2(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i : prices) {
            if (i < min) {
                min = i;
            } else if (i - min > profit) {
                profit = i - min;
            }
        }
        return profit;
    }

    public static int KevinSolution(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    private static void Test(int arraySize) {
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
        long elapsed = Time(MaxStockProfit::ForrestSolution, arrCopy);
        System.out.println(label + ": " + elapsed + " milliseconds");
        if (printResult)
            System.out.println(Arrays.toString(arrCopy));

        arrCopy = CopyArray(arr);
        label = "Kevin";
        elapsed = Time(MaxStockProfit::KevinSolution, arrCopy);
        KevinSolution(arrCopy);
        System.out.println(label + ": " + elapsed + " milliseconds");
        if (printResult)
            System.out.println(Arrays.toString(arrCopy));
        arrCopy = CopyArray(arr);

        label = "Forrest 2";
        elapsed = Time(MaxStockProfit::ForrestSolution2, arrCopy);
        System.out.println(label + ": " + elapsed + " milliseconds");
        if (printResult)
            System.out.println(Arrays.toString(arrCopy));

        arrCopy = CopyArray(arr);
        label = "Kevin, second attempt";
        elapsed = Time(MaxStockProfit::KevinSolution, arrCopy);
        KevinSolution(arrCopy);
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
            arr[i] = rnd.nextInt(9);
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
