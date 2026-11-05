class Solution {
    public boolean validPalindrome(String s) {
        
        return rec(true, 0, s.length() - 1, s.toCharArray());
    }

    public boolean rec(boolean isOk, int l, int r, char[] arr) {

        if(l > r) return true;

        if(arr[l] == arr[r]) {
            return rec(isOk, l+1, r-1, arr);
        }

        if(!isOk && arr[l] != arr[r]) {
            return false;
        }

        return rec(false, l+1, r, arr) || 
               rec(false, l, r-1, arr);

    }
}