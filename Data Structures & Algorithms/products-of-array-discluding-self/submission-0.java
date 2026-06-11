class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res=new int[nums.length];

        /* for(int i=0;i<nums.length;i++){
            int prod=1;
            int flag=0;
            if(nums[i]==0){
                flag++;
            }
            for(int j=0;j<nums.length;j++){
                prod*=nums[j];
            }

            if(flag==0){
                res[i]=prod/nums[i];
            }else{
                res[i]=prod;
            }
        }
 */
        for(int i=0;i<nums.length;i++){
            int prod=1;

            for(int j=0;j<nums.length;j++){
                if(j==i) continue;
                else{
                    prod*=nums[j];
                }

            }

            res[i]=prod;
        }

        return res;
    }
}  
