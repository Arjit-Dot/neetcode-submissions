class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int windowSize = s1.length();
        
        // Base case: If s1 is larger than s2, it's impossible to find a permutation
        if (windowSize > s2.length()) {
            return false;
        }
        
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        
        // Initialize the frequency arrays for the very first window
        for (int i = 0; i < windowSize; i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        
        // Slide the window across the rest of s2
        for (int i = windowSize; i < s2.length(); i++) {
            // Check if the current window is a match
            if (Arrays.equals(s1count, s2count)) {
                return true;
            }
            
            // Add the new character entering the window on the right
            s2count[s2.charAt(i) - 'a']++;
            
            // Remove the character left behind on the left
            s2count[s2.charAt(i - windowSize) - 'a']--;
        }
        
        // Check the very last window after the loop ends
        return Arrays.equals(s1count, s2count);
    }
}