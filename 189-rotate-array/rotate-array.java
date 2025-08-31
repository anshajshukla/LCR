class Solution {
    private void swap(int [] nums,int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
        return;
    }
    private void rotatePart(int[] nums,int i ,int j){
        while(i<j){
        swap(nums,i,j);
        i++;
        j--; 
        }
        return;
    }
    public void rotate(int[] nums, int k) {
        if(k>nums.length-1) {
            k = k%nums.length;
        }
        rotatePart(nums,0,nums.length-1); // this will at first 
        rotatePart(nums,0,k-1);
        rotatePart(nums,k,nums.length-1);
        
        return;        
    }
}