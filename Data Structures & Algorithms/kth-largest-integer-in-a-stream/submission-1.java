class KthLargest {
    PriorityQueue<Integer> minHeap;
    int K;

    public KthLargest(int k, int[] nums) {
        K=k;
        minHeap=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            minHeap.add(nums[i]);
        }

        setHeap(minHeap,k);
    }
    public int add(int val) {
        minHeap.add(val);  

        setHeap(minHeap,K);

        return minHeap.peek();

    }

    private void setHeap(PriorityQueue<Integer> minHeap, int k){
        while(minHeap.size()>k){
            minHeap.poll();
        }

        return;
    }

}
