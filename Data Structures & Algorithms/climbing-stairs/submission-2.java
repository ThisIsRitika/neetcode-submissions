class Solution {
    public int climbStairs(int n) {
        int[] memo=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            memo[i] = -1;
        }
        return fibonacci(n,memo);
    }

    private int fibonacci(int n,int[] memo){
        if(n==1 || n==0) return 1;
        //if(n<0) return 0;
        if(memo[n]!=-1) return memo[n];
        
        return memo[n]=fibonacci(n-1,memo)+fibonacci(n-2,memo);
    }
}
