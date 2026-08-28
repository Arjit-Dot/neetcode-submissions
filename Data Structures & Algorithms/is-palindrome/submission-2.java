class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            // 1. If the left character is not alphanumeric, skip it
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } 
            // 2. If the right character is not alphanumeric, skip it
            else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } 
            // 3. Both are alphanumeric, compare them case-insensitively
            else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        
        return true;
    }
}