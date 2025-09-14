class Solution {
    public boolean hasMatch(String s, String p) {
        int x = p.indexOf("*");
        String b = p.substring(0, x);
        String e = p.substring(x + 1);

        int i = s.indexOf(b);
        int j = s.lastIndexOf(e);

        return i != -1 && j != -1 && i + b.length() <= j;
    }
}
