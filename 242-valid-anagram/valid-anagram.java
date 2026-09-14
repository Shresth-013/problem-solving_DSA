class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> sMap=new HashMap<>();
        HashMap<Character, Integer> tMap=new HashMap<>();

        for(int i=0;i<s.length();i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
            // so basically this above does is that in a map for say "s", u will put 
            // the char at that string then u will check how many times it appeared ,
            //ofcourse start with zero then add +1 every time, this is what the getorDef does
        }
        return sMap.equals(tMap);
    }
}