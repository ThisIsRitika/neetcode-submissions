class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int n=piles.length;
        int start=1;
        int end=piles[n-1];
        int mid=0;
        int ans=0;

        while(start<=end){
            mid=start+(end-start)/2;
            long hrs=minHrs(piles,mid);
            if(hrs<=h){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        return ans;
    }

    private long minHrs(int[] piles, int mid){
        long hrs=0;
        for(int i=0;i<piles.length;i++){
            hrs+=(long)(piles[i]+mid-1)/mid;
        }

        return hrs;
    }
}