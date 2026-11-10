
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet<>();

        for (int num : nums) {
            numsSet.add(num);
        }

        int max = 0;

        for (int num : numsSet) {

            // Only start counting at the beginning of a sequence
            if (!numsSet.contains(num - 1)) {

                int curr = 1;

                while (numsSet.contains(num + curr)) {
                    curr++;
                }

                max = Math.max(max, curr);
            }
        }

        return max;
    }
}
