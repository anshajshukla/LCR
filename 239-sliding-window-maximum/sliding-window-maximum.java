class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> b[1] - a[1]);
        int [] result = new int[n-k+1];
        int ind = 0;
        for(int i =0;i<n;i++){
            pq.offer(new int []{i,arr[i]});
            while(pq.peek()[0]<i-k+1) pq.poll();
            if(i-k+1>=0) result[ind++] = pq.peek()[1];
        }
        return result;   
    }
}