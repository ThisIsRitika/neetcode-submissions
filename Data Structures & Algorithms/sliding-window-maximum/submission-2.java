class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] maxArr=new int[n-k+1];

        Deque<Integer> deq=new ArrayDeque<>();

        for(int i=0;i<n;i++){
            //remove the max element from top if it is not the part of the window
            while(!deq.isEmpty() && deq.peekFirst()<i-k+1) deq.pollFirst();

            //remove the smaller elements from last such that the max element remains on the top
            while(!deq.isEmpty() && nums[deq.peekLast()]<nums[i]) deq.pollLast();

            deq.offerLast(i);

            if(i>=k-1) maxArr[i-k+1]=nums[deq.peekFirst()];
        }

        return maxArr;
    }
}
