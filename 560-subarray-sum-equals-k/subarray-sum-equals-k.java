class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1);           // empty prefix sums to 0 — CRITICAL base case
    int sum = 0, count = 0;
    for (int n : nums) {
        sum += n;
        // if (sum - k) was seen before, that gap between the two points sums to k
        count += prefixCount.getOrDefault(sum - k, 0);
        prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
    }
    return count;
    }
}