class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");

        for(String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;

        while(i<str.length()) {
            int sizeToRead = 0;
            StringBuilder numSB = new StringBuilder("");
            while(str.charAt(i) != '#') {
                numSB.append(str.charAt(i));
                i++;
            }
            sizeToRead = Integer.parseInt(numSB.toString());
            i++;
            res.add(str.substring(i, i+sizeToRead));
            i+=sizeToRead;
        }

        return res;
    }
}
