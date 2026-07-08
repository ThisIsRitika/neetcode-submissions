class Solution {
    static int[] twoSum(int arr[],int target){
        int n=arr.length;
        int[] result=new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]+arr[j]==target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
 
        return result;
    }

    
}