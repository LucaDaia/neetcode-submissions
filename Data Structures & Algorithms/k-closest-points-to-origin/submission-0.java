

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                b[0] * b[0] + b[1] * b[1],
                a[0] * a[0] + a[1] * a[1]
            )
        );

        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) maxHeap.poll();
        }

        int[][] res = new int[k][2];
        for (int i = k - 1; i >= 0; i--) res[i] = maxHeap.poll();
        return res;
    }
}