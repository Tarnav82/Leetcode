class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        
        int total = 0;
        int n = s.length();
        
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && roman.get(s.charAt(i)) < roman.get(s.charAt(i + 1))) {
                total -= roman.get(s.charAt(i));
            } else {
                total += roman.get(s.charAt(i));
            }
        }
        
        return total;
    }
}