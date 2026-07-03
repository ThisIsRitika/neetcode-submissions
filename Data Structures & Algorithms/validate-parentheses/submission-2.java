class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else if(!stack.isEmpty() && (s.charAt(i)==')' || s.charAt(i)==']' || s.charAt(i)=='}')){
                char ch=stack.peek();
                if(s.charAt(i)==')' && ch=='(') stack.pop();
                else if(s.charAt(i)==']' && ch=='[') stack.pop();
                else if(s.charAt(i)=='}' && ch=='{') stack.pop();
                else return false;
                    
            }else return false;
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
