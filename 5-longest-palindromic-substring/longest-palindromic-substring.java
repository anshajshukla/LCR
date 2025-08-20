class Solution {
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // When loop breaks, pointers are one step beyond the palindrome
        return right - left - 1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        // declare start and end only for the substring calculations 
        int start = 0;
        int end = 0;
        for(int i =0;i<n;i++){
            // treat every iteration the center 
            // Case 1 --> 
            int len1 = expand(s,i,i);
            int len2 = expand(s,i,i+1);

            int max = Math.max(len1,len2);

            if(max>(end-start+1)){
                start = i  - (max-1)/2;
                end = i + max/2;
            }

        }
        return s.substring(start,end+1);
        
    }
}