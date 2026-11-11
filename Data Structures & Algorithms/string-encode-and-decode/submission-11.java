class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder("");

        for(String s : strs) {
            sb.append("#");
            sb.append(String.valueOf(s.length()));
            sb.append('#');
            sb.append(s);
        }

        return sb.toString();
    }

    
public List<String> decode(String str) {

    List<String> res = new ArrayList<>();

    for (int i = 0; i < str.length(); i++) {

        if (str.charAt(i) == '#') {

            int j = i + 1;

            while (j < str.length() && Character.isDigit(str.charAt(j))) {
                j++;
            }

            int subLength = Integer.parseInt(str.substring(i + 1, j));

            String newS = str.substring(j+1, j+1 + subLength);
            res.add(newS);

            i = j+1 + subLength - 1;
        }
    }

    return res;
}

}
