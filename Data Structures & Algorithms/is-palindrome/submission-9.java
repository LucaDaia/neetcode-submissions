class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;

        int i=0;
        int j = s.length() - 1;
        char[] charArr = s.toCharArray();

        while (i <= j) {

            if(!Character.isLetterOrDigit(charArr[i])) {i++; continue;} 
            if(!Character.isLetterOrDigit(charArr[j])) {j--; continue;}
            if(Character.toLowerCase(charArr[i]) != Character.toLowerCase(charArr[j])) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
