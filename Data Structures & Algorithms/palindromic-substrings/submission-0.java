class Solution {
    public int countSubstrings(String s) {
        int totalCount = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // 1. Count all odd-length palindromes centered at i
            totalCount += expandAndCount(s, i, i);
            
            // 2. Count all even-length palindromes centered between i and i + 1
            totalCount += expandAndCount(s, i, i + 1);
        }
        
        return totalCount;
    }

    private int expandAndCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; // Every valid outward step is a distinct palindrome
            left--;
            right++;
        }
        return count;
    }
}