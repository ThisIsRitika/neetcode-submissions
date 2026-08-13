class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap=new PriorityQueue<>();

        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
        }

        int limit=nums.length-k;
        for(int i=0;i<limit;i++){
            heap.poll();
        }

        return heap.peek();
    }
}
