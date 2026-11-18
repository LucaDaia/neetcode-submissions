class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = 0;
        for(int i = 0; i<piles.length; i++) {
            if(piles[i] > max) max = piles[i];
        }

        int l=1;
        int r = max;

        while(l <= r) {
            
            int m = l + (r-l)/2;

            if(eatingTime(m, piles) > h) l = m + 1;
            else r = m-1;
        }

        return l;
    }

    public long eatingTime(int rate, int[] piles) {
        long res = 0;
        for(int i=0;i<piles.length;i++) {
            if(piles[i]%rate!=0) res++;
            res+=piles[i]/rate;
        }

        return res;
    }
}
