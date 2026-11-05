class Solution {

    //abcdcefg
    // seen:   c d 
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> seen = new HashSet<>();

        int left = 0;
        for(int right = 0; right<s.length(); right++) {
            if(!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                res = Math.max(res, right - left + 1);
            } else {
                while(!seen.isEmpty() && s.charAt(left)!= s.charAt(right)) {
                    seen.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
        }

        return res;
    }
}
