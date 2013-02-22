public class ValidParentheses {
    public boolean isValid(String s) {
        char[] array  = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for(char c:array){
            if(isLeft(c))
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                if(!isPair(stack.pop(),c))
                    return false;
            }
        }
        return stack.isEmpty();  
    }
    
    private boolean isLeft(char c){
        return c=='('||c=='{'||c=='[';
    }
    
    private boolean isPair(char left,char right){
        return left=='('&&right==')' || left=='['&&right==']' || left=='{'&&right=='}';
    }
}
