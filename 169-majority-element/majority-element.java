class Solution {
    public int majorityElement(int[] nums) {
        int candidate= nums[0];
        int count =0;

        for(int n : nums){
            if(count==0){
                candidate= n;
            }

            if(n==candidate){
                count = count + 1;
            }else{
                count = count - 1;
            }
        }
        return candidate;
    }
}