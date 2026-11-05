class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for(int k=0; k<=n;k++) {
            int res = 0;
            for(int i=0;i<32;i++) {
                if((1<<i & k) != 0 )
                res++;
            }
            arr[k] = res;
        }
        return arr;
    }
}
