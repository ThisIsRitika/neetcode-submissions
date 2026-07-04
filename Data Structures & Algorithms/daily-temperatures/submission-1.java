class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int n=temperatures.length;
        int[] result=new int[n];
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()]<temperatures[i]){
                int idx=st.pop();
                result[idx]=i-idx;
            }

            st.push(i);
            
        }

        return result;
    }
}
