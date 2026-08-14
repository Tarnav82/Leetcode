class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        int min = Integer.MIN_VALUE; 
        int n = nums.length;
        for(int i = 0 ; i<1 ; i++){
            if(min<nums[i]){
               min = nums[i];
            }
        }
        return min;
    }
    
}