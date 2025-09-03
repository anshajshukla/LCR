class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int [] result = new int[n-k+1];
        int rIndex = 0;
        for(int i =0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()<i-k+1){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]) {
                dq.pollLast();
            }
            

            dq.offerLast(i);

            if(i>=k-1){
                result[rIndex++] = arr[dq.peekFirst()]; 
            }


        }
        return result;

        
    }
}