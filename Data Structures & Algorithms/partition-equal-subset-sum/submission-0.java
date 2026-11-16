class Solution {
    Boolean memo[][];
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2!=0) return false;

        int target=sum/2;
        memo=new Boolean[n][target+1];
        return dfs(nums,target,0);
    }

    private boolean dfs(int[] nums, int target, int idx){
        if(idx==nums.length) return target==0;

        if(target<0) return false;

        if(memo[idx][target]!=null) return memo[idx][target];

        memo[idx][target]=dfs(nums,target,idx+1) || dfs(nums,target-nums[idx],idx+1);

        return memo[idx][target];
        
    }
}