class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        // Find the first (leftmost) occurrence
        result[0] = findFirst(nums, target); 
        // If the first occurrence is found, find the last (rightmost)
        if (result[0] != -1) {
            result[1] = findLast(nums, target);
        }
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;
        int s = 0;
        int l = nums.length - 1;
        while (s <= l) {
            int mid = s + (l - s) / 2;
            if (nums[mid] == target) {
                index = mid;     // A potential answer is found
                l = mid - 1;     // Continue searching on the left side for an earlier occurrence
            } else if (nums[mid] > target) {
                l = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1;
        int s = 0;
        int l = nums.length - 1;
        while (s <= l) {
            int mid = s + (l - s) / 2;
            if (nums[mid] == target) {
                index = mid;     // A potential answer is found
                s = mid + 1;     // Continue searching on the right side for a later occurrence
            } else if (nums[mid] > target) {
                l = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return index;
    }
}
