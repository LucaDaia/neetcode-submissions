class Solution {
    public String longestCommonPrefix(String[] strs) {
        int nrStr = strs.length;
        int minLen = 1000;
        for (String s : strs) {
            if(s.length() < minLen) {
                minLen = s.length();
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i=0;i<minLen; i++) {
            char curr = strs[0].charAt(i);
            for(String s: strs) {
                if(s.charAt(i) != curr) {
                    return res.toString();
                }
            }
            res.append(curr);
        }

        return res.toString();
    }
}