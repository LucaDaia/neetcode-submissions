class Solution {

    //abcdcefg
    // seen:   c d 
    public int lengthOfLongestSubstring(String s) {
      
        Set<Character> seen = new HashSet<>();
        int res = 0;
        int curr = 0;

        int left = 0;
        int right = 0;

        char[] charArr = s.toCharArray();
        int n = charArr.length;

        while(right < charArr.length) {
            if(!seen.contains(charArr[right])) {
                seen.add(charArr[right]);
                curr++;
                res = Math.max(res, curr);
                right++;
            } else {
                while(charArr[left] != charArr[right]) {
                    seen.remove(charArr[left]);
                    left++;
                    curr--;
                }
                seen.remove(charArr[left]);
                left++;
                curr--;
            }
        }

        return res;
        
    }
}
