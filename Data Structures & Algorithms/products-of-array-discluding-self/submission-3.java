class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];

        //result is my suffix array
        result[n-1]=1;

        for(int i=n-2;i>=0;i--){
            result[i]=result[i+1]*nums[i+1];
        }

        //calculate prefix and multiply at each index
        int prefix=1;

        for(int j=1;j<n;j++){
            prefix=prefix*nums[j-1];
            result[j]*=prefix;
        }

        return result;
    }
}  
