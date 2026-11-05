class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        int biggestPile = piles[0];
        for(int i=1;i< piles.length;i++) {
            biggestPile = Math.max(biggestPile, piles[i]);
        }

//        for(int i=1;i<=biggestPile;i++) {
//            if(hoursToFinish(piles, i) <= h) {
//                res = i;
//                break;
//            }
//        }

        int left = 1;
        int right = biggestPile;
        
        while(left <= right) {
            int middle = left + (right - left)/2;
            
            if(hoursToFinish(piles, middle) <= h) {
                right = middle-1;
                res = middle;
            } else left = middle + 1;
        }
        

        return res;

    }

        public int hoursToFinish(int[] piles, int k) {
        int res = 0;
        for(int i=0;i<piles.length;i++) {
            if(piles[i]%k!=0) {
                res+=piles[i]/k + 1;
            } else res+= piles[i]/k;
        }

        return res;
    }
}
