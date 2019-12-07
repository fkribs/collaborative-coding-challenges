// Given an array of n positive integers and a positive integer s, 
// find the minimal length of a contiguous subarray of which
// the sum ≥ s. If there isn't one, return 0 instead.

// Example: 
// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal 
// length under the problem constraint.

class MinSizeSubArraySum {
    public static void main(String[] args) {
        int[] input = new int[]{2,3,1,2,4,3};
        int forrestResult = minSizeForrest(input);
        int kevinResult = minSizeKevin(input);
        System.out.println(forrestResult);
        System.out.println(kevinResult);
    }

    public static int minSizeForrest(int s, int [] nums){
        return -1;
    }

    public static int minSizeKevin(int s, int [] nums){
        return -1;
    }
}