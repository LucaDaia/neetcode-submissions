class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s);
            sb.append("{");
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++) {
            if(str.charAt(i) == '{') {
                result.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(str.charAt(i));
            }
            
        }

        return result;
      
    }
}
