class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }

        return parse(s, i, 0, sign);
    }

    private int parse(String s, int index, int total, int sign) {
        if (index >= s.length() || !Character.isDigit(s.charAt(index))) {
            return sign * total;
        }

        int digit = s.charAt(index) - '0';

        if (total > (Integer.MAX_VALUE - digit) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return parse(s, index + 1, total * 10 + digit, sign);
    }
}