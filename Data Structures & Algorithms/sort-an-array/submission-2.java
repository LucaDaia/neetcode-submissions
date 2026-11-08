class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);

        return nums;
    }

    public void sort(int[] nums, int l, int r) {
        if (l >= r)
            return;

        int m = (l + r) / 2;

        sort(nums, l, m);
        sort(nums, m + 1, r);

        // merge

        int i = l;
        int j = m + 1;

        List<Integer> temp = new ArrayList<>();

        while (i <= m && j <= r) {
            if (nums[i] < nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }

        // fill the remaining ints
        while (i <= m) {
            temp.add(nums[i]);
            i++;
        }

        while (j <= r) {
            temp.add(nums[j]);
            j++;
        }

        // move temp into the original array
        int listCounter = 0;
        for (int k = l; k <= r; k++) {
            nums[k] = temp.get(listCounter);
            listCounter++;
        }
    }
}