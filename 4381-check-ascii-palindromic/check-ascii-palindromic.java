class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            String bin = Integer.toBinaryString(c);
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            sb.append(bin);
        }
        String binaryString = sb.toString();
        String reversed = sb.reverse().toString();
        return binaryString.equals(reversed);
    }
}