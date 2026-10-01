class Solution {
    int memo[][];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];

        memo=new int[n][2];
        for(int i=0;i<n;i++){
            memo[i][0]=-1;
            memo[i][1]=-1;
        } 

        return Math.max(dfs(0,1,nums),dfs(1,0,nums));
    }

    private int dfs(int i,int flag,int[] nums){
        if(i>=nums.length || (flag==1 && i==nums.length-1)) return 0;

        if(memo[i][flag]!=-1) return memo[i][flag];

        return memo[i][flag]=Math.max(nums[i]+dfs(i+2,flag,nums),dfs(i+1,flag,nums));
    }
}
