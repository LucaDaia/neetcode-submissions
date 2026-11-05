class Solution {
    public int missingNumber(int[] nums) {
        int res = -1;
        Set<Integer> set = new HashSet();
        for(int i=0;i<nums.length;i++) {
            set.add(nums[i]);
        }
        set.add(nums.length + 1);

        for(int i=0;i<set.size();i++) {
            if(!set.contains(i)) {
                res = i;
                break;
            }
        }

        return res;
    }
}
