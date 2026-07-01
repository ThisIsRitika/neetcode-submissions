class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];

        //result array is my prefix array
        result[0]=1;
        
        for(int i=1;i<n;i++){
            result[i]=result[i-1]*nums[i-1];
        }

        //calculate and multiply suffix at each index
        int suffix=1;
        for(int j=n-2;j>=0;j--){
            suffix=suffix*nums[j+1];
            result[j]*=suffix;  
        }

        return result;
    }
}  
