class Solution {
    public int[] sortArray(int[] nums) {
        divide(0, nums.length - 1, nums);
        return nums;
    }

    public void divide(int l, int r, int[] nums) {
        if(l >= r) return;

        int m = (l + r)/2;

        divide(l, m, nums);
        divide(m+1, r, nums);

        reorder(l,r,m, nums);

    }

    public void reorder(int l, int r, int m, int[] nums) {

        int[] tempArr = new int[r-l+1];
        int i = l;
        int j = m+1;
        int k = 0;

        while(i<=m && j<=r) {
            if(nums[i] < nums[j]) {
                tempArr[k] = nums[i];
                i++;
            } else {
                tempArr[k] = nums[j];
                j++;
            }
            k++;
        }

        while(i<=m) {
            tempArr[k] = nums[i];
            k++;
            i++;
        }

        while(j<=r) {
            tempArr[k] = nums[j];
            j++;
            k++;
        }

        for(int idx = l; idx <= r; idx++) {
            nums[idx] = tempArr[idx - l];
        }
    }
}