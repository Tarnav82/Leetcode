class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        // Loop through the array using a simple index-based for loop
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++; // Increment the active streak
                
                // Update maxCount if the current streak is the longest we've seen
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                }
            } else {
                // We hit a 0, so the current streak is broken
                currentCount = 0;
            }
        }
        
        return maxCount;
    }
}