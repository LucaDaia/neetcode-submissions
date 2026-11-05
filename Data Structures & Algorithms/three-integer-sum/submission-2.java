class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

       // [-2, 0, 1, 1, 2]

        for(int i=0; i< nums.length;i++) {
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {

                if(nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(nums[i]);
                    newList.add(nums[left]);
                    newList.add(nums[right]);
                    if(!result.contains(newList)) {
                        result.add(newList);
                    }
                    left++;
                    right--;
                }

                if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }

            }
        }
        return result;
    }
}
