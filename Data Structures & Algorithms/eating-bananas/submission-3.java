class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int bestRate = -1;
        int maxPile = 0;
        for(int pile: piles) {
            maxPile = Math.max(maxPile, pile);
        }

        int low = 1;
        int high = maxPile;

        while(low <= high) {
            int middle = low + (high - low)/2;

            if(hoursTaken(piles, middle) <= h){
                high = middle - 1;
                bestRate = middle;
            } else if(hoursTaken(piles, middle) > h) {
                low = middle + 1;
            }
        }

        return bestRate;
        
    }

    public int hoursTaken(int[] piles, int rate) {
        int res = 0;
        for(int pile : piles) {
            res+=pile/rate;
            if(pile%rate != 0) {
                res++;
            }
        }
        return res;
    }
}
