

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        int windowSize = s1.length();
        
        // Initialize frequency arrays for s1 and the first window of s2
        for (int i = 0; i < windowSize; i++) {
            hash1[s1.charAt(i) - 'a']++;
            hash2[s2.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(hash1, hash2)) return true;
        
        // Slide the window across s2
        for (int i = windowSize; i < s2.length(); i++) {
            hash2[s2.charAt(i) - 'a']++;                  // Add the new character entering the window
            hash2[s2.charAt(i - windowSize) - 'a']--;     // Remove the old character leaving the window
            
            if (Arrays.equals(hash1, hash2)) return true;
        }
        
        return false;
    }
}