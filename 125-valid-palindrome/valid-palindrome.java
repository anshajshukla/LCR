class Solution {
    

public boolean isPalindrome(String s) {
    String s1 = s.toLowerCase();
    StringBuilder str = new StringBuilder();
    
    for (int i = 0; i < s1.length(); i++) {
        char ch = s1.charAt(i);
        if ((ch >= 'a' && ch <= 'z' )||(ch>='0' && ch<='9')) {
            str.append(ch);
        }
    }


    String cleaned = str.toString();
    String reversed = str.reverse().toString();
    System.out.println(cleaned);
    System.out.println(reversed);
    return cleaned.equals(reversed);
}
}
