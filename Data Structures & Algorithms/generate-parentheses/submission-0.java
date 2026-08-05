class Solution {
    public List<String> generateParenthesis(int n) {
        StringBuilder sb=new StringBuilder();
        List<String> ans=new ArrayList<>();

        backtrack(n,ans,sb,0,0);

        return ans;
    }

    private void backtrack(int n, List<String> ans, StringBuilder sb, int open, int close){
        if(sb.length()==n*2){
            ans.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            backtrack(n,ans,sb,open+1,close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            sb.append(')');
            backtrack(n,ans,sb,open,close+1);
            sb.deleteCharAt(sb.length()-1);

        }

    }
}
