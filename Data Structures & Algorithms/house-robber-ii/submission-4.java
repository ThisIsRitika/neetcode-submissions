class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        
        if(n==1) return nums[0]; 
        int memo[]=new int[n];
        for(int i=0;i<n;i++) memo[i]=-1;

        int memoC[]=new int[n-1];
        for(int i=0;i<n-1;i++) memoC[i]=-1;

        int numC[]=new int[n-1];
        for(int i=0;i<n-1;i++) numC[i]=nums[i];

        return Math.max(dfs(numC,0,memoC),dfs(nums,1,memo));

    }

    private int dfs(int[] nums,int i,int[] memo){
        if(i>=nums.length) return 0;

        if(memo[i]!=-1) return memo[i];

        return memo[i]=Math.max(nums[i]+dfs(nums,i+2,memo),dfs(nums,i+1,memo));
    }
}
