class Solution {
    class Pair{
        double dist;
        int arr[];

        Pair(double dist, int[] arr){
            this.dist=dist;
            this.arr=arr;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> heap=new PriorityQueue<>((a,b)-> Double.compare(b.dist, a.dist));

        for(int i=0;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];

            double sum=(x*x)+(y*y);
            double dist=Math.sqrt(sum);

            Pair pair=new Pair(dist, new int[]{x,y});

            heap.add(pair);
        }

        while(heap.size()>k) heap.poll();

        int[][] result=new int[k][2];

        for(int i=0;i<k;i++){
            Pair pair=heap.poll();
            result[i][0]=pair.arr[0];
            result[i][1]=pair.arr[1];
        }

        return result;

    }
}
