class MedianFinder {

    PriorityQueue<Integer> leftHeap;
    PriorityQueue<Integer> rightHeap;

    public MedianFinder() {
        leftHeap=new PriorityQueue<>(Collections.reverseOrder());//maxheap
        rightHeap=new PriorityQueue<>();//minheap
    }
    
    public void addNum(int num) {
        if(rightHeap.isEmpty()) rightHeap.add(num);

        else if(num>rightHeap.peek()) rightHeap.add(num);
        else leftHeap.add(num);

        int diff=rightHeap.size()-leftHeap.size();
        if(Math.abs(diff)>1){
            if(diff>0) leftHeap.add(rightHeap.poll());
            else rightHeap.add(leftHeap.poll());
        }

        
    }

    public double findMedian() {
        int size=rightHeap.size()+leftHeap.size();
        if(size%2==0){
            return (double)(rightHeap.peek()+leftHeap.peek())/2;
        }else{
            if(rightHeap.size()>leftHeap.size()) return (double) rightHeap.peek();
            else return (double) leftHeap.peek();
        }

        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */