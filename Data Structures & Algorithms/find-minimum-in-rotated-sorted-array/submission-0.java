class Solution {
    public int findMin(int[] nums) {
        int min=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                min=i+1;
                break;
            }

        }

        return nums[min];
    }
}