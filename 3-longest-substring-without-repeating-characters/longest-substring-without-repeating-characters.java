class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charFrequency = new int[128];
    int maxLength = 0;
    int left = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);
        charFrequency[c]++;

        while (charFrequency[c] > 1) {
            charFrequency[s.charAt(left)]--;
            left++;
        }

        maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
    }
}