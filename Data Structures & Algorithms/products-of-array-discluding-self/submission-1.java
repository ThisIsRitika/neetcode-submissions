class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        int prefix[]=new int[n];
        int suffix[]=new int[n];

        //enter values in prefix array
        prefix[0]=1;

        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }

        //enter values in suffix array
        suffix[n-1]=1;

        for(int j=n-2;j>=0;j--){
            suffix[j]=suffix[j+1]*nums[j+1];
        }

        //fill values in result array prefix*suffix
        for(int k=0;k<n;k++){
            result[k]=prefix[k]*suffix[k];
        }

        return result;
    }
}  
