class Solution {
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result=new ArrayList<>();
        StringBuilder curr=new StringBuilder("(");

        backtrack(n,curr,1,0);
        return result; 
    }

    private void backtrack(int n, StringBuilder curr, int open, int close){
        if(curr.length()==n*2){
            result.add(curr.toString());
            return;
        } 

        if(open<n){
            curr.append("(");
            backtrack(n,curr,open+1,close);
            curr.deleteCharAt(curr.length()-1);
        }   

        if(close<open){
            curr.append(")");
            backtrack(n,curr,open,close+1);
            curr.deleteCharAt(curr.length()-1);
        }

            
    }
}
