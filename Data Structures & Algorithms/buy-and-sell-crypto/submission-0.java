class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int profit=0;
        int maxP=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(prices[j]>prices[i]){
                    profit=prices[j]-prices[i];
                    maxP=Math.max(maxP,profit);
                } 
                
            }
        }

        return maxP;
    }
}
