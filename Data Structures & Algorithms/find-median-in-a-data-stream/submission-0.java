class MedianFinder {

    ArrayList<Integer> list;
    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        int n=list.size();
        list.sort(null);

        if(n%2!=0){
            return (double)list.get(n/2);
        }else{
            int x=list.get(n/2);
            int y=list.get((n/2)-1);
            return (double)(x+y)/2;
        }

    }
}
