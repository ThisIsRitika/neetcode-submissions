class Twitter {

    HashMap<Integer, ArrayList<int[]>> posts;
    HashMap<Integer, ArrayList<Integer>> follows;
    
    int count;

    public Twitter() {
        posts=new HashMap<>();
        follows=new HashMap<>();
        
        count=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        posts.putIfAbsent(userId, new ArrayList<>());
        posts.get(userId).add(new int[]{tweetId,count++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> heap=new PriorityQueue<>((a,b)->b[1]-a[1]);

        if(posts.get(userId)!=null){
            for(int[] post : posts.get(userId)){
                heap.offer(post);
            }
        }
        

        if(follows.get(userId)!=null){
            ArrayList<Integer> followers=follows.get(userId);
            if(!followers.isEmpty()){
                for(Integer id : followers){
                    if(id==userId) continue;
                    for(int[] post : posts.get(id)){
                        heap.offer(post);
                    }   
                }
            }
        }

        

        List<Integer> result=new ArrayList<>();
        int max=1;
        while(!heap.isEmpty() && max<=10){
            result.add(heap.poll()[0]);
            max++;
        }

        return result;


    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId,new ArrayList<>());
        if(follows.get(followerId).contains(followeeId)) return;
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follows.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
