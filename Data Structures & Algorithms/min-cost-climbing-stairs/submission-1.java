class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        memo=new int[n];
        for(int i=0;i<n;i++) memo[i]=-1;
        return Math.min(dfs(cost,0),dfs(cost,1));
    }

    private int dfs(int[] cost,int i){
        if(i>=cost.length) return 0;

        if(memo[i]!=-1) return memo[i];
        return memo[i]=cost[i]+Math.min(dfs(cost,i+1),dfs(cost,i+2));

    }
}
