class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }

        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder()); 
        Queue<int[]> q=new ArrayDeque<>();

        for(int i=0;i<freq.length;i++){
            if(freq[i]>0) heap.offer(freq[i]);
        }

        int time=0;

        while(!heap.isEmpty() || !q.isEmpty()){
            time++;
            
            if(heap.isEmpty()) time=q.peek()[1];
            else{
                int count=heap.poll()-1;
                if(count>0) q.offer(new int[]{count,time+n});
            }

            if(!q.isEmpty() && q.peek()[1]==time){
                heap.offer(q.poll()[0]);
            }
        }

        return time;


    }
}
