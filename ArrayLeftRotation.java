import sun.reflect.generics.reflectiveObjects.NotImplementedException;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
// A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

// Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

// Input Format

// The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform).
// The second line contains  space-separated integers describing the respective elements of the array's initial state.

// Constraints
// 1 <= n <= 10^5
// 1 <= d <= n
// 1 <= ai <= 10^6

// Output Format

// Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.
// Output Format

// Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

// Sample Input

// 5 4
// 1 2 3 4 5
// Sample Output

// 5 1 2 3 4
// Explanation

// When we perform  left rotations, the array undergoes the following sequence of changes:

// Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.

class ArrayLeftRotation {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5};
        int numIntegers = 5;
        int numLeftRotations = 4;
        System.out.println("Forrest: " + ForrestSolution(numIntegers, numLeftRotations, array));
        System.out.println("Kevin: " + KevinSolution(numIntegers,numLeftRotations,array));
    }

    public static int[] ForrestSolution(int numIntegers, int numLeftRotations, int[] initialArray) {
        throw new NotImplementedException();
    }
//should 
    public static int[] KevinSolution(int numIntegers, int numLeftRotations, int[] initialArray) {
        throw new NotImplementedException();
    }
}