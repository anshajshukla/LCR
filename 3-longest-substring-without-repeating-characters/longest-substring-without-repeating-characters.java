class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0 ;
        int end = 0; 
        HashSet<Character> h = new HashSet<>();
        for(int i =0;i<s.length();i++){

            while(h.contains(s.charAt(i))) {
                h.remove(s.charAt(end));
                end++;
            }
            h.add(s.charAt(i));
            ans = Math.max(ans, i - end + 1);
        }
        return ans;
        
    }
}