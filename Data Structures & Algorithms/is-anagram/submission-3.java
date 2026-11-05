class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freq1 = new HashMap<>();
        Map<Character, Integer> freq2 = new HashMap<>();

        for(char c: s.toCharArray()) {
            freq1.put(c, freq1.getOrDefault(c, 1) + 1);
        }

        for(char c: t.toCharArray()) {
            freq2.put(c, freq2.getOrDefault(c, 1) + 1);
        }

        if(freq1.equals(freq2)) {
            return true;
        }
         else return false;
    }

}

