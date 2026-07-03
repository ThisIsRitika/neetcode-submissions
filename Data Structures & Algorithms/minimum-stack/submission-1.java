class MinStack {

    Stack<Integer> stack;
    Stack<Integer> extra;

    public MinStack() {
        stack=new Stack<>();
        extra=new Stack<>();     
    }
    
    public void push(int val) {
        stack.push(val);
        if(!stack.isEmpty() && !extra.isEmpty()){
            int min=extra.peek();
            extra.push(Math.min(stack.peek(),min));
        }else{
            extra.push(val);
        }
    }
    
    public void pop() {
        int a=0;
        if(!stack.isEmpty()){
           a=stack.pop();
        }

        if(!extra.isEmpty()){
            extra.pop();
        }

        
    }
    
    public int top() {
        int top=stack.peek();
        return top;
    }
    
    public int getMin() {
        if(!extra.isEmpty()) return extra.peek();
        else return stack.peek();
    }
}
