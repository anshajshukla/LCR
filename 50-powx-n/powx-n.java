class Solution {
    public double myPow(double x, int n) {
        double ans = pow(x, n);
        if (n > 0)
            return ans;
        else
            return (double) (1 / ans);
    }

    private double pow(double x, int m) {
        double ans = 1;
        long n = Math.abs((long) m);
        while (n > 0) {
            // if odd 
            if ((n % 2) == 1) {
                ans = ans * x;
            }
            x *= x;
            n = n / 2;
        }
        return ans;
    }
}