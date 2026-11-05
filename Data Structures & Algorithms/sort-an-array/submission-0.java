class Solution {
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
        return nums;
    }

    public void divide(int[] nums, int l, int r) {
        
        if(l>=r) return;
        int m = (l + r)/2;

        divide(nums, l, m);
        divide(nums, m+1, r);
        merge(nums, l,m,r);
    }

    public void merge(int[] nums, int l, int m, int r) {

        List<Integer> tempArray = new ArrayList<>();

        int p1 = l;
        int p2 = m+1;

        while(p1<=m && p2<=r) {
            if(nums[p1] <= nums[p2]) {
                tempArray.add(nums[p1]);
                p1++;
            } else {
                tempArray.add(nums[p2]);
                p2++;
            }
        }

        while(p1<=m) {
            tempArray.add(nums[p1]);
            p1++;
        }

        while(p2<=r) {
            tempArray.add(nums[p2]);
            p2++;
        }

        for(int i=l; i<=r;i++) {
            nums[i] = tempArray.get(i-l);
        }
    }
}