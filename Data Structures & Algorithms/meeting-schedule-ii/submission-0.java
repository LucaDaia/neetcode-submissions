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
        
        int[] startArr = new int[intervals.size()];
        int[] endArr = new int[intervals.size()];

        for(int i=0;i<intervals.size(); i++) {
            startArr[i] = intervals.get(i).start;
            endArr[i] = intervals.get(i).end;
        }

        Arrays.sort(startArr);
        Arrays.sort(endArr);

        int startPointer = 0;
        int endPointer = 0;

        int count = 0;
        int maxCount = 0;

        while(startPointer < startArr.length) {
            if(startArr[startPointer] < endArr[endPointer]) {
                startPointer++;
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                endPointer++;
                count--;
            }
        }

        return maxCount;
    }
}
