class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<stones.length;i++){
            maxHeap.add(stones[i]);
        }

        while(maxHeap.size()!=1 && maxHeap.size()!=0){
            int x=maxHeap.poll();
            int y=maxHeap.poll();

            if(x==y) continue;
            else if(x<y){
                maxHeap.add(y-x);
            }else{
                maxHeap.add(x-y);
            }
        }
        
        if(maxHeap.size()==0) return 0;
        return maxHeap.peek();
    }
}
