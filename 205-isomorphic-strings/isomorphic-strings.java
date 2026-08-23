class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] indexS = new int[256];
        int[] indexT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (indexS[charS] != indexT[charT]) {
                return false;
            }

            indexS[charS] = i + 1;
            indexT[charT] = i + 1;
        }

        return true;
    }
}