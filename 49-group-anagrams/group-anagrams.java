class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // We'll use a Map to group anagrams.
        // The key will be a String representation of the character counts.
        // The value will be a List of original strings that are anagrams.
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Create an array to store the frequency of each character (a-z)
            int[] charCounts = new int[26];
            for (char c : str.toCharArray()) {
                charCounts[c - 'a']++; // Increment count for the corresponding character
            }

            // Convert the int array to a String to use as a HashMap key.
            // Directly using int[] as a key won't work correctly because
            // arrays don't override equals() and hashCode() from Object,
            // meaning two arrays with the same content would be considered different objects by the Map.
            String key = Arrays.toString(charCounts);

            // If the key (character count string) is not already in the map,
            // put it in with a new empty ArrayList.
            map.putIfAbsent(key, new ArrayList<>());

            // Get the list associated with the key and add the current string.
            map.get(key).add(str);
        }

        // Return a new ArrayList containing all the lists of anagrams (the values from the map).
        return new ArrayList<>(map.values());
    }
}
