class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> dictionary = new HashMap<>();
        dictionary.put('{', '}');
        dictionary.put('(', ')');
        dictionary.put('[', ']');

        Stack<Character> stack = new Stack<>();

        char[] charArr = s.toCharArray();

        for(int i=0;i<charArr.length;i++) {

            if(dictionary.containsKey(charArr[i])) {
                stack.push(charArr[i]);
            } else {
                if(stack.isEmpty()) return false;
                if(charArr[i] != dictionary.get(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
                
            }
        }

        if(stack.size() > 0) return false;
        else return true;
    }
}
