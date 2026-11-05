class Solution {

    public String encode(List<String> strs) {
              String result = "";
        for(String str : strs) {
            result +=str + "/";
        }

        return result;
    }

    public List<String> decode(String str) {
            List<String> result = new ArrayList<>();
        char[] strChar = str.toCharArray();

        String currWord = "";
        for(int i=0;i<strChar.length;i++) {
            if(strChar[i] != '/') {
                currWord += strChar[i];
            } else {
                result.add(currWord);
                currWord = "";
            }
        }

        return result;
    }
}
