class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int li = 0;
        int ri = 0;

        StringBuilder sb = new StringBuilder();

        while(li<word1.length() && ri<word2.length()) {
            sb.append(word1.charAt(li++));
            sb.append(word2.charAt(ri++));
        }

        if(li == word1.length()) {
            while(ri < word2.length()) {
                sb.append(word2.charAt(ri++));
            }
        } else if(ri == word2.length()) {
            while(li <word1.length()) {
                sb.append(word1.charAt(li++));
            }
        }

        return sb.toString();
    }
}