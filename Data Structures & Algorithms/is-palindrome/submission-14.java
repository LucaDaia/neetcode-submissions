class Solution {
    public boolean isPalindrome(String s) {
        
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        while(left<=right) {

           while (left < right && !Character.isLetterOrDigit(charArray[left])) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(charArray[right])) {
                right--;
            }

            if(Character.toLowerCase(charArray[left]) != Character.toLowerCase(charArray[right])) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
