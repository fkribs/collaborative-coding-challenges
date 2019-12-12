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
        int[] input = new int[] { 2, 3, 1, 2, 4, 3, 0, 7};
        int minSum = 7;
        int forrestResult = minSizeForrest(minSum, input);
        int kevinResult = minSizeKevin(minSum, input);
        System.out.println(forrestResult);
        System.out.println(kevinResult);

    }

    public static int minSizeForrest(int s, int[] nums) {
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
        if (backIndex == frontIndex)
            return 1;
        return backIndex - frontIndex;
    }

    public static int minSizeKevin(int s, int[] nums) {
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
        return (min != Integer.MAX_VALUE ? min : 0);
    }
}