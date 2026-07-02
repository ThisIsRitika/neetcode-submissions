class Solution {
    public int maxArea(int[] heights) {
        int start=0;
        int end=heights.length-1;
        int maxWater=0;

        while(start<end){
            //calculate water in the current container
            int height=Math.min(heights[start],heights[end]);
            int width=end-start;
            int water=height*width;

            //find the maximum water contained
            maxWater=Math.max(maxWater, water);

            //move index to find water in other container
            if(heights[start]<heights[end]) start++;
            else end--;
        }

        return maxWater;
    }
}
