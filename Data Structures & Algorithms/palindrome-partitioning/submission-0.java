class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> curr=new ArrayList<>();

        backtrack(s,0,curr,ans);

        return ans;
    }

    private void backtrack(String s, int idx, List<String> curr, List<List<String>> ans){
        if(idx==s.length()){
            ans.add(new ArrayList<>(curr));
        }

        for(int i=idx;i<s.length();i++){
            String sub=s.substring(idx,i+1);
            if(checkPalindrome(sub)){
                curr.add(sub);
                backtrack(s,i+1,curr,ans);
                curr.remove(curr.size()-1);
            }   
        }
    }

    private boolean checkPalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
