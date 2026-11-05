class Solution {
    public int reverse(int x) {
        long rev = 0;
        int temp = x;
        while (temp != 0) {
            rev = rev * 10 + (temp % 10);
            temp /= 10;
        }
        if (rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}