import java.util.Arrays;

// Given an array of integers A sorted in non-decreasing order, 
//return an array of the squares of each number, 
//also in sorted non-decreasing order.

// Example 1:
// Input: [-4,-1,0,3,10]
// Output: [0,1,9,16,100]

// Example 2:
// Input: [-7,-3,2,3,11]
// Output: [4,9,9,49,121]

// Note:
// 1 <= A.length <= 10000
// -10000 <= A[i] <= 10000
// A is sorted in non-decreasing order.

class Solution {
    public static void main(String[] args) {
        int[] array = new int[] { -4, -1, 0, 3, 10 };
        System.out.println(Arrays.toString(ForrestSolution(array)));
        System.out.println(Arrays.toString(KevinSolution(array)));
    }

    public static int[] ForrestSolution(int[] A) {
        int length = A.length;
        int[] squares = new int[length];
        int[] negatives = new int[length];
        int squaredIndex = 0;
        int sourceIndex = 0;
        int negativeIndex = 0;
        int currentValue = 0;
        while (squaredIndex < length - 1) {
            if (sourceIndex <= length - 1)
                currentValue = A[sourceIndex++];

            if (currentValue < 0) {
                negatives[negativeIndex++] = currentValue * currentValue;
                continue;
            }
            currentValue = currentValue * currentValue;
            for (int i = 0; i < negativeIndex; i++) {
                if (currentValue > negatives[i]) {
                    squares[squaredIndex++] = negatives[i];
                    negatives[i] = 999999999;
                    continue;
                }
            }
            squares[squaredIndex++] = currentValue;
        }
        return squares;
    }

    public static int[] KevinSolution(int[] A) {
        return new int[A.length];
    }
}