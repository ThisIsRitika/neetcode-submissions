class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int idx=0;
            for(int j=i+1;j<n;j++){
                if(temperatures[i]<temperatures[j]){
                    idx++;
                    result[i]=idx;
                    break;
                }else{
                    idx++;
                }
            }

            if(idx==0) result[i]=0;
        }

        return result;
    }
}
