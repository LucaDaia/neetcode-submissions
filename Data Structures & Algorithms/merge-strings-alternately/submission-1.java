class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder("");

        int l = 0;
        int r = 0;

        while (l < word1.length() && r < word2.length()) {
            res.append(word1.charAt(l));
            res.append(word2.charAt(r));
            l++;
            r++;
        }

        while (l < word1.length()) {
            res.append(word1.charAt(l));
            l++;
        }

        while (r < word2.length()) {
            res.append(word2.charAt(r));
            r++;
        }

        return res.toString();
    }
}