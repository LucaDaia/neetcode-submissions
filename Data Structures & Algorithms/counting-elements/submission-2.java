class Solution {
    public int countElements(int[] arr) {
        Arrays.sort(arr);

        int res=0;
        int carry = 0;
        for(int i=0;i<arr.length - 1;i++) {
            if(arr[i] == arr[i+1]) carry++;
            if(arr[i] + 1 == arr[i+1]) {
                res=res+carry + 1;
                // res++;
                carry=0;
                }
            if(arr[i] != arr[i+1]) carry = 0;
        }
        return res;
    }
}
