public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int k, int remainingSum, int startDigit,
                           List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            if (remainingSum == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int digit = startDigit; digit <= 9; digit++) {
            if (digit > remainingSum) {
                break;
            }

            current.add(digit);
            backtrack(k, remainingSum - digit, digit + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}