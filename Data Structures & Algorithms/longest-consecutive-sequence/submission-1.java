class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1) return 0; 
        
        Set<Integer> set = new HashSet<>();
        int longest = 1;

        for (int num : nums) {
            set.add(num);
        }

        int i = 0;
        while(i<nums.length) {
            int currLength = 1;
            int currNumber = nums[i];
            while(set.contains(currNumber + 1)) {
                currLength++;
                currNumber++;
            }
            longest = Math.max(currLength, longest);
            i++;
        }

        return longest;
    }
}
