class Solution {
    int[] memo;
    public int rob(int[] nums) {
        int n=nums.length;
        memo=new int[n];
        return Math.max(dfs(nums,0),dfs(nums,1));
    }

    private int dfs(int[] nums, int i){
        if(i>=nums.length) return 0;
        if(memo[i]!=0) return memo[i];

        return memo[i]=nums[i]+Math.max(dfs(nums,i+2),dfs(nums,i+3));
    }
}
