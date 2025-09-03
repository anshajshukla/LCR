class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean hasOne = false;

        // Step 1: Check if 1 is present
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) hasOne = true;
        }
        if (!hasOne) return 1;

        // Step 2: Replace invalid numbers with 1
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }

        // Step 3: Mark presence
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] > 0) {
                nums[val - 1] = -nums[val - 1];
            }
        }

        // Step 4: Find first missing
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i + 1;
        }

        return n + 1;
    }
}
