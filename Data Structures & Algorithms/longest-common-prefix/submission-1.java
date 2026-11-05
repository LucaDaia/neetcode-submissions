class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (i >= strs[0].length()) break;

            char currChar = strs[0].charAt(i);

            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != currChar) {
                    return sb.toString();
                }
            }

            sb.append(currChar);
            i++;
        }

        return sb.toString();
    }
}