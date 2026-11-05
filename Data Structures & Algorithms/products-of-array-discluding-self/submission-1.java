class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];

        int sufProd = 1;
        for(int i=0;i<nums.length;i++) {
            suffix[i] = sufProd * nums[i]; 
            sufProd*=nums[i];
        }

        int preProd = 1;
        for(int i=nums.length - 1;i>= 0;i--) {
            prefix[i] = preProd * nums[i];
            preProd*=nums[i];
        }

        for(int i=1;i<nums.length-1;i++) {
            res[i] = suffix[i-1]*prefix[i+1];
        }

        res[0] = prefix[1];
        res[nums.length - 1] = suffix[nums.length - 2];

        return res;
    }
}  
