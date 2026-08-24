class Solution {

    Map<Integer, List<Integer>> preMap=new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited=new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int pre[] : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int course=0;course<numCourses;course++){
            if(!dfs(course, visited)) return false;
        }

        return true;
        
    }

    private boolean dfs(int course, boolean[] visited){
        if(visited[course]==true) return false;

        if(preMap.get(course).isEmpty()) return true;

        visited[course]=true;
        for(int pre : preMap.get(course)){
            if(!dfs(pre,visited)) return false;
        }

        visited[course]=false;
        preMap.put(course, new ArrayList<>());
        return true;
    }
}
