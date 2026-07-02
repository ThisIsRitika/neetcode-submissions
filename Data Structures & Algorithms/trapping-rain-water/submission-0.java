class Solution {
    public int trap(int[] height) {
        int n=height.length;

        int left[]=new int[n]; 
        int right[]=new int[n]; 

        //initialise 
        left[0]=height[0];
        right[n-1]=height[n-1];

        //filling leftmax array
        for(int i=1;i<n;i++){
            left[i]=Math.max(left[i-1],height[i]);
        }

        //filling rightmax array
        for(int j=n-2;j>=0;j--){
            right[j]=Math.max(right[j+1],height[j]);
        }

        //calculate the following variables
        int waterLevel=0;
        int trapped=0;
        int totalTrap=0;

        //compare leftmax and rightmax to find total trapped water
        for(int k=0;k<n;k++){
            waterLevel=Math.min(left[k],right[k]);
            trapped=waterLevel-height[k];
            totalTrap+=trapped;
        }

        return totalTrap;
    }
}
