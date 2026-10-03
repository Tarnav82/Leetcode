
class Solution {
    public List addOperators(String num, int target) {
        List result = new ArrayList<>();
        if (num == null || num.isEmpty()) {
            return result;
        }
        backtrack(result, num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void backtrack(List result, String num, int target, StringBuilder path, int index, long eval, long multed) {
        if (index == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        long currentVal = 0;
        int len = path.length();

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            currentVal = currentVal * 10 + (num.charAt(i) - '0');

            if (index == 0) {
                path.append(currentVal);
                backtrack(result, num, target, path, i + 1, currentVal, currentVal);
                path.setLength(len);
            } else {
                path.append('+').append(currentVal);
                backtrack(result, num, target, path, i + 1, eval + currentVal, currentVal);
                path.setLength(len);

                path.append('-').append(currentVal);
                backtrack(result, num, target, path, i + 1, eval - currentVal, -currentVal);
                path.setLength(len);

                path.append('*').append(currentVal);
                backtrack(result, num, target, path, i + 1, eval - multed + multed * currentVal, multed * currentVal);
                path.setLength(len);
            }
        }
    }
}