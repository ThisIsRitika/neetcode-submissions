class Solution {
    Map<Integer, Integer> dp;
    public int numDecodings(String s) {
        dp=new HashMap<>();
        dp.put(s.length(),1);
        return dfs(s,0);
    }

    private int dfs(String s,int i){
        if(i==s.length()) return 1;
        if(s.charAt(i)=='0') return 0;

        if(dp.containsKey(i)) return dp.get(i);

        int res=dfs(s,i+1);

        if(i<s.length()-1){
            if(s.charAt(i)=='1' || (s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                res+=dfs(s,i+2);
            }
        }

        dp.put(i,res);

        return res;
    }
}
