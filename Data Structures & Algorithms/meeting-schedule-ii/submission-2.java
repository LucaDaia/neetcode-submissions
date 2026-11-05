/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) {
            return 0;
        }

        Queue<Integer> queue = new PriorityQueue<>();

        intervals.sort((a,b) -> Integer.compare(a.start, b.start));
        queue.add(intervals.get(0).end);
        int i = 1;

        while(i<intervals.size() && !queue.isEmpty()) {
            if(queue.peek() > intervals.get(i).start) {
                queue.add(intervals.get(i).end);
            } else {
                queue.poll();
                queue.add(intervals.get(i).end);
            }
            i++;
        }

        return queue.size();
    }
}
