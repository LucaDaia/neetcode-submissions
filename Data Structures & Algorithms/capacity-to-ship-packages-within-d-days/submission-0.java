class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxCap = 0;
        int allWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            maxCap = weights[i] > maxCap ? weights[i] : maxCap;
            allWeight+=weights[i];
        }

        //solution space for capacity is [maxCap, sum(weights)]

        int l = maxCap;
        int r = allWeight;

        while(l<=r) {

            int m = l + (r-l)/2;

            if(calculateDays(m, weights) > days) l = m+1;
            else r = m - 1;
        }

        return l;
    }

    public int calculateDays(int capacity, int[] weights) {
        int res = 1;
        int currSum = 0;
        for(int i = 0; i<weights.length; i++) {
            if(currSum + weights[i] > capacity) {
                res++;
                currSum = weights[i];
            } else currSum+=weights[i];
        }

        return res;
    }
}