class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> h = new HashMap<>();
        boolean flag = false;
        for(int i=0;i<nums.length;i++){
            if(h.containsKey(nums[i])){
                if(i-h.get(nums[i])<=k) flag = true;
            }
            h.put(nums[i],i); 
        }
        return flag;
        
        
    }
}