class Solution {
    public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> SCount = new HashMap<>();
    SCount.put(0, 1);           
    int sum = 0, count = 0;
    for (int n : nums) {
        sum += n;
        count += SCount.getOrDefault(sum - k, 0);
        SCount.put(sum, SCount.getOrDefault(sum, 0) + 1);
    }
    return count;
    }
}