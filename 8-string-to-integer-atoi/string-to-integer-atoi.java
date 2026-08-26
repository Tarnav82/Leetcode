class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int i = 0, n = s.length();
        
        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == n) return 0;
        
        // 2. Check sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        
        // 3. Convert digits and handle overflow
        int result = 0;
        int INT_MAX = Integer.MAX_VALUE; // 2147483647
        int INT_MIN = Integer.MIN_VALUE; // -2147483648
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check overflow
            if (result > (INT_MAX - digit) / 10) {
                return sign == 1 ? INT_MAX : INT_MIN;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}