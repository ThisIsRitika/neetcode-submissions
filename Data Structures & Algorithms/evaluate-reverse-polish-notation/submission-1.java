class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                int result=b+a;
                stack.push(Integer.toString(result));
            }else if(tokens[i].equals("-")){
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                int result=b-a;
                stack.push(Integer.toString(result));
            }else if(tokens[i].equals("*")){
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                int result=b*a;
                stack.push(Integer.toString(result));
            }else if(tokens[i].equals("/")){
                int a=Integer.parseInt(stack.pop());
                int b=Integer.parseInt(stack.pop());
                int result=b/a;
                stack.push(Integer.toString(result));
            }else{
                stack.push(tokens[i]);
            }
        }

        return Integer.parseInt(stack.peek());
    }
}
