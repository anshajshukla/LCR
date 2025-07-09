class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        do{
            fast = square(square(fast));
            slow = square(slow);

        } while(fast!=slow);
        return slow==1;
    }
    public int square(int n) {
        int sum = 0;
        while (n > 0) {
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
        }
        return sum;
    }
    
}