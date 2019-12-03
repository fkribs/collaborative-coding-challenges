// Given n non-negative integers a1, a2, ..., an , where each 
// represents a point at coordinate (i, ai). n vertical lines 
// are drawn such that the two endpoints of line i is at (i, ai) 
// and (i, 0). Find two lines, which together with x-axis forms 
// a container, such that the container contains the most water.

// Note: You may not slant the container and n is at least 2.

// Example: 
// Input: [1,8,6,2,5,4,8,3,7]
// Output: 49

class WaterContainer{
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxAreaForrest(arr));
        System.out.println(maxAreaKevin(arr));
    }

    public static int maxAreaForrest(int[] height){
        int length = height.length;
        int max = 0;
        for(int i = 0; i < length; i++){
            for(int i2 = 0; i2 < length; i2++){
                int minHeight = Math.min(height[i], height[i2]);
                int area = minHeight * (i2 - i);
                if (area > max){
                    max = area;
                }
            }
        }
        return max;
    }

    //two pointer approach
    public static int maxAreaKevin(int[] height){
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        
        while(left <= right){
            if(height[left] < height[right]){
                max = Math.max(max, height[left] * (right - left));
                left++;
            }else{
                max = Math.max(max, height[right] * (right - left));
                right--;
            }
        }
        return max;
    }
}