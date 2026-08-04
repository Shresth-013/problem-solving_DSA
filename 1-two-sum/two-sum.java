class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> two= new HashMap<>();// storing the number and index

        for(int i =0; i<nums.length;i++){
            int comp = target-nums[i];

            if( two.containsKey(comp)){// if the comp already in 
                return new int[] {two.get(comp), i};// return the indices
            }
            two.put(nums[i],i);// otherwise put number and index
        }
        return null;
    }
}