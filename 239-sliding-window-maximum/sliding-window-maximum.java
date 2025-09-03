import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        if (n == 0 || k == 0) return new int[0];

        // Max heap: compare values descending
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[] result = new int[n - k + 1];
        int rIndex = 0;

        for (int i = 0; i < n; i++) {
            // 1. Add current element (value, index)
            pq.offer(new int[]{arr[i], i});

            // 2. Remove elements outside the window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // 3. Record result once window is full
            if (i >= k - 1) {
                result[rIndex++] = pq.peek()[0];
            }
        }

        return result;
    }
}
