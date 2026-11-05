class TimeMap {

    HashMap<String, List<Pair<String, Integer>>> hashMap;

    public TimeMap() {
        hashMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(hashMap.containsKey(key)) {
        hashMap.get(key).add(new Pair(value, timestamp));
        } else {
            List<Pair<String, Integer>> createdList = new ArrayList<>();
            createdList.add(new Pair(value, timestamp));
            hashMap.put(key, createdList);
        }
    }
    
    public String get(String key, int timestamp) {
        
        if(!hashMap.containsKey(key)) {
            return "";
        }

        List<Pair<String, Integer>> tempList = hashMap.get(key);
        int n = tempList.size();

        int low = 0;
        int high = n-1;
        int middle = -1;
        int currBest = -1;

        while(low <= high) {
            middle = low + (high - low)/2;

            if(tempList.get(middle).getValue() == timestamp) {
                currBest = middle;
                break;
            } else if(tempList.get(middle).getValue() < timestamp) {
                low = middle + 1;
                currBest = Math.max(currBest, middle);
            } else {
                high = middle - 1;
            }
            
        }

        if(currBest == -1) return "";
        return tempList.get(currBest).getKey();
    }
}
