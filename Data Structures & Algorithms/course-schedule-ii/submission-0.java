class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];

        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }

        int finish=0;
        int i=0;
        while(!q.isEmpty() && i<numCourses){
            int node=q.poll();
            finish++;
            result[i++]=node;

            for(int nei : adj.get(node)){
                indegree[nei]--;

                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        if(finish==numCourses) return result;
        return new int[0];
    }
}
