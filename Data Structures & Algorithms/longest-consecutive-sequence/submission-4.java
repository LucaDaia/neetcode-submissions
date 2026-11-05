class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0) return 0;

        Set<Integer> store = new HashSet();

        for(int num: nums) {
            store.add(num);
        }

        int res = Integer.MIN_VALUE;

        for(int i = 0; i<nums.length; i++) {
            if(store.contains(nums[i] - 1)) {
                int currSeq = 2;
                while(store.contains(nums[i] + 1)) {
                    currSeq++;
                    nums[i]++;
                }

                res = Math.max(res, currSeq);
            }
        }

        if(res== Integer.MIN_VALUE) {
            return 1;
        }
        return res;
    }
}
