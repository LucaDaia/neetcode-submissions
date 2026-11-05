class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int[] previous = {intervals[0][0], intervals[0][1]};
        int i=1; 

        while(i<n) {
            if(previous[1] >= intervals[i][0]) {
                previous[0] = Math.min(previous[0], intervals[i][0]);
                previous[1] = Math.max(previous[1], intervals[i][1]);
                i++;
            } else {
                res.add(previous);
                previous = intervals[i];
                i++;
            }
        }
        res.add(previous);

        return res.toArray(new int[res.size()][]);
    }
}
