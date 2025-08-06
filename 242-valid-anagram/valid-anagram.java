class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n!=m) return false;
        HashMap<Character,Integer> h = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            h.put(ch, h.getOrDefault(ch, 0) + 1);
        }
        for(int j=0;j<m;j++){
            char temp = t.charAt(j);
            if(!h.containsKey(temp)) return false;
            else{
                h.put(temp,h.get(temp)-1);
                if(h.get(temp)<0) return false;
            }
        }
        return true;
    }
}