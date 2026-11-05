class Solution {
    public boolean isAnagram(String s, String t) {
         Map<Character, Integer> map = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)- 1);
            } else {
                map.put(c, -1);
            }

            if(map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
    }

