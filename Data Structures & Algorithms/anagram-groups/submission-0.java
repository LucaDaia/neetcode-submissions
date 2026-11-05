class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
           Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length;i++) {
            int[] count = new int[26];
            for(int j=0;j<strs[i].length();j++) {
                count[strs[i]. charAt(j) - 'a'] +=1;
            }
            if(!map.containsKey(Arrays.toString(count))) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(Arrays.toString(count), temp);
            } else {
                map.get(Arrays.toString(count)).add(strs[i]);
            }

        }

        return  map.values().stream().toList();
    }
}
