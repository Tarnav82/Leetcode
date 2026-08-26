import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[256];
        for (char ch : s.toCharArray()) {
            freq[ch]++;
        }
        
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                chars.add((char) i);
            }
        }
        
        chars.sort((c1, c2) -> freq[c2] - freq[c1]);
        
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            int count = freq[c];
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}