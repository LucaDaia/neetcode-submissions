class Solution {
    public boolean checkInclusion(String s1, String s2) {
        

       if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count characters in s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        // Initialize first window in s2
        for (int i = 0; i < s1.length(); i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        // Check initial window
        if (matches(freq1, freq2)) {
            return true;
        }

        // Slide the window across s2
        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            freq2[s2.charAt(right) - 'a']++;       // include new char
            freq2[s2.charAt(left) - 'a']--;        // remove leftmost char
            left++;

            if (matches(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }

    public boolean matches(int[] a, int[] b) {
      for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
