class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0;

        // Base case: next1 represents dp[n] = 1
        int next1 = 1; 
        // Represents dp[n + 1] (out of bounds = 0)
        int next2 = 0; 

        for (int i = n - 1; i >= 0; i--) {
            int curr = 0; // Represents dp[i], resets to 0 at each step

            // If it's '0', curr stays 0. Otherwise, calculate branches:
            if (s.charAt(i) != '0') {
                // Branch 1: Take 1 digit (dp[i] = dp[i + 1])
                curr = next1;

                // Branch 2: Take 2 digits (dp[i] += dp[i + 2])
                if (i + 1 < n) {
                    int twoDigits = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                    if (twoDigits <= 26) { 
                        curr += next2;
                    }
                }
            }

            // Shift the two pointers one step to the left for the next iteration
            next2 = next1;
            next1 = curr;
        }

        // At the end of the loop (after i = 0), next1 holds the answer for dp[0]
        return next1;
    }
}