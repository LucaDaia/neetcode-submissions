class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        int res = n;

        while(!seen.contains(res)) {
            seen.add(res);
            res = calcValue(res);
            if(res == 1) return true;
        }

        return false;
    }

    public int calcValue(int n) {
        int res = 0;
        while(n!=0) {
            res+= (n%10) * (n%10);
            n= n/10;
        }
        return res;
    }
}
