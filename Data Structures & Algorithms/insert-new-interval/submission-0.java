class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        int n = intervals.length;

        List<int[]> res = new ArrayList<>();

        // add all intervals before newInterval
        while (i < n && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        // merge overlapping intervals
        while (i < n && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(new int[]{newInterval[0], newInterval[1]});

        // add remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}

