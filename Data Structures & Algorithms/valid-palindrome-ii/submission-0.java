class Solution {
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        boolean[] res = new boolean[2];
        res[0] = false;

        rec(true, 0, s.length() - 1, arr, res);

        return res[0];
    }

    public void rec(boolean isOk, int l, int r, char[] arr, boolean[] res) {
        if (l >= r) {
            res[0] = true;
            return;
        }

        if (!isOk) {
            if (arr[l] != arr[r]) {
                return;
            }

            else
                rec(false, l + 1, r - 1, arr, res);
        } else {
            if (arr[l] != arr[r]) {
                rec(false, l + 1, r, arr, res);
                rec(false, l, r - 1, arr, res);
            } else {
                rec(true, l + 1, r - 1, arr, res);
            }
        }
    }
}