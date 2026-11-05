class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> set = new HashSet();

        for(int i =0;i<nums.length;i++) {
            set.add(nums[i]);
        }


        for(int i=0;i<nums.length;i++) {
            int curr = nums[i];
            int currLen = 1;
            while(!set.isEmpty() && set.contains(curr + 1)) {
                currLen++;
                curr += 1;
            }

            longest = Math.max(longest, currLen);
        }

        return longest;
    }
}
