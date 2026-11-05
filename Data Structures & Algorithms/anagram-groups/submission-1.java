class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> resMap = new HashMap<>();

        for(String s : strs) {
            String freq = createFreqMap(s);
            List<String> temp;
            if(resMap.containsKey(freq)) {
                temp = resMap.get(freq);
                temp.add(s);
                resMap.put(freq, temp);
            }
            else {
                temp = new ArrayList<>();
                temp.add(s);
                resMap.put(freq, temp);
            }
        }

        return new ArrayList<>(resMap.values());
    }

    public String createFreqMap(String s) {
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++) {
            freq[s.charAt(i) - 'a']++;
        }

        return Arrays.toString(freq);
    }
}
