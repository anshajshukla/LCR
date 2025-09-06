class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i : stones ) pq.add(i);
        while(pq.size()!=1){
            int f = pq.poll();
            int s = pq.poll();
            pq.add(f-s);
        }
        return pq.peek();
        
    }
}