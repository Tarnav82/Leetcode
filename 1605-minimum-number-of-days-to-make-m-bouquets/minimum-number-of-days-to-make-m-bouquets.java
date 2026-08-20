class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }

        return left;
    }

    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int consecutiveBloomed = 0;

        for (int bDay : bloomDay) {
            if (bDay <= day) {
                consecutiveBloomed++;
                if (consecutiveBloomed == k) {
                    bouquets++;
                    consecutiveBloomed = 0; 
                }
            } else {
                consecutiveBloomed = 0; 
            }
        }

        return bouquets >= m;
    }
}