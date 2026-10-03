class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=piles[0];
        for(int i=1;i<piles.length;i++){
            r=Math.max(r,piles[i]);
        }

        int res=r;
        while(l<=r){
            //the mid is actually the speed or rate at which koko eat bananas
            int k=(l+r)/2;
            long hrs=0;
            for(int pile: piles){
                hrs+=Math.ceil((double)pile/k);
            }

            if(hrs<=h){
                res=k;
                r=k-1;
            }else{
                l=k+1;
            }
        }

        return res;
    }
}
