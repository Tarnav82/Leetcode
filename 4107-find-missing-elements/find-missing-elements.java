class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];

           
            int val = current + 1;
            while (val < next) {
                result.add(val);
                val++;
            }
        }

        return result;
    }
}