class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int maxArr[]=new int[n-k+1];

        int idx=0;
        for(int i=0;i<n-k+1;i++){
            int maxEle=Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
                maxEle=Math.max(maxEle,nums[j]);
            }

            maxArr[idx]=maxEle;
            idx=idx+1;
        }

        return maxArr;
    }
}
