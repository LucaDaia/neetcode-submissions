class Solution {
    public int mySqrt(int x) {
        
        int l = 1;
        int r = x/2;

        if(x == 1) return 1;
        if(x == 0) return 0;

        while(l <= r) {
            int m = l + (r-l)/2;
            long square = (long)m*m;

            if(square == x) return m;

            if(square < x) l= m+1;

            if(square >= x) r=m-1;
        }

        return r;
    }
}