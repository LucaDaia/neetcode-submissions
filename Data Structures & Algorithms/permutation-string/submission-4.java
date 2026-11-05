class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freqWindow = new int[26];

        for(int i=0;i<s1.length();i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        for(int i=0;i<s1.length(); i++) {
            freqWindow[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(freq1, freqWindow)) return true;
        
        int left = 0;

        for(int right = s1.length(); right<s2.length();right++) {
           freqWindow[s2.charAt(left) - 'a']--;
           freqWindow[s2.charAt(right) - 'a']++;

           if(Arrays.equals(freq1, freqWindow)) return true;

           left++;

        }

        return false;
    }
}
