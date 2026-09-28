class Solution {
    public int maxDepth(String s) {
        int maxDepth =0;
        int currDepth=0;

        for(int i=0;i<s.length();i++){
            char currChar=s.charAt(i);

            if(currChar=='('){
                currDepth++;
                maxDepth=Math.max(maxDepth,currDepth);
            }
            else if(currChar==')'){
                currDepth--;
            }
        }
        return maxDepth;
    }
}