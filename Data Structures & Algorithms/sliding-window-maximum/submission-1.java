class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int maxArr[]=new int[n-k+1];
        
        //max heap contains arr of size 2 [0]->value [1]->index
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->b[0]-a[0]);

        for(int i=0;i<n;i++){
            //add an array of element and its index in maxheap
            heap.offer(new int[]{nums[i],i});

            //if the index ain't valid remove it i.e. the max element at top is not the part of the window
            while(heap.peek()[1]<i-k+1) heap.poll();

            if(i>=k-1) maxArr[i-k+1]=heap.peek()[0];

        }

        return maxArr;
    }
}
