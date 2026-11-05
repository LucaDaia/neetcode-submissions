class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        int haveCount = 0;
        int needCount;

        int[] res = new int[2];
        int currMinLen = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        needCount = need.size();

        for (Character c : need.keySet()) {
            have.put(c, 0);
        }

        char[] charArr = s.toCharArray();
        int left = 0;

        for (int right = 0; right < charArr.length; right++) {
            char rc = charArr[right];

            if (have.containsKey(rc)) {
                have.put(rc, have.get(rc) + 1);

                if (have.get(rc).equals(need.get(rc))) {
                    haveCount++;
                }
            }

            while (haveCount == needCount) {
                if (right - left + 1 < currMinLen) {
                    currMinLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char lc = charArr[left];
                left++;

                if (have.containsKey(lc)) {
                    have.put(lc, have.get(lc) - 1);
                    if (have.get(lc) < need.get(lc)) {
                        haveCount--;
                    }
                }
            }
        }

        return currMinLen == Integer.MAX_VALUE
                ? ""
                : s.substring(res[0], res[1] + 1);
    }
}
