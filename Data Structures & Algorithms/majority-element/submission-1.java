class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majElmnt = nums[0];

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == majElmnt) {
                count++;
            } else count--;

            if(count <= 0) {
                majElmnt = nums[i];
            }
        }

        return majElmnt;
    }
}