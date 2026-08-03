class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int candidate = 0;
 int max = 0 ; 
        for(int num:nums ){
            if (max == 0){
                candidate = num;
            }
            if(num == candidate){
                max++;
            }else{
                max--;
            }
           
            
            }
         return candidate;   
        }
        
    }