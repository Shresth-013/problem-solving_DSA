class Solution {
    public boolean isValid(String s) {
       Deque<Character> stack=new ArrayDeque<>();

       for(char currChar:s.toCharArray()){
    if(currChar=='(' ||currChar== '{' || currChar=='['){
        stack.push(currChar);
    } else if(stack.isEmpty() || !isMatching(stack.pop(),currChar)){
        return false;
    }
    
       }
       return stack.isEmpty();
    }
    private boolean isMatching(char opening,char closing){
        return 
        (opening == '(' && closing == ')') ||
         (opening == '{' && closing == '}') ||
          (opening == '[' && closing == ']');
    }
}