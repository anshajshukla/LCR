class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Sorting the key approach 
        Map<String, List<String>> m = new HashMap<>();
        for(String str : strs){
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            m.putIfAbsent(s,new ArrayList<>());
            m.get(s).add(str);
        }
        return new ArrayList<>(m.values());

        
    }
}