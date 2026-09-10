class Solution {
    public double myPow(double x, int n) {
       return fastPow(x, (long) n);
    }

    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1.0 / fastPow(x, -n);
        }

        double half = fastPow(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
        
    }
}