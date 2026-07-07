class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int k=1;
        long hr=0;

        //ceil the solution (round up 1.5 as 2 and not 1
        boolean flag=true;
        while(flag){
            for(int i=0;i<n;i++){
                hr+=((long)piles[i]+k-1)/k;
            }
            if(hr>h){
                hr=0;
                k++;
            }else{
                flag=false;
            }
        }

        return k;
    }
}
