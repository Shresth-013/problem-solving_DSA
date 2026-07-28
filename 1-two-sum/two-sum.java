class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> two= new HashMap<>();

        for(int i =0; i<nums.length;i++){
            int comp = target-nums[i];

            if( two.containsKey(comp)){
                return new int[] {two.get(comp), i};
            }
            two.put(nums[i],i);
        }
        return null;
    }
}