class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord == endWord) return 0;

        int n=wordList.size();
        int m=wordList.get(0).length();

        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        Map<String, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(wordList.get(i),i);
        }

        //adjacency list representation of the strings..where each string is a node
        //an edge exists between the nodes if they differ by only one character
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int count=0;
                for(int k=0;k<m;k++){
                    if(wordList.get(i).charAt(k)!=wordList.get(j).charAt(k)) count++;
                }

                if(count==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        Queue<Integer> q=new LinkedList<>();
        int res=1;
        Set<Integer> visit=new HashSet<>();

        //now for each character of the beginWord try replacing it with all characters from a-z
        //if replacing one character makes a word from the wordlist then add it to the queue and mark visited
        for(int i=0;i<m;i++){
            for(char c='a';c<='z';c++){
                if(c==beginWord.charAt(i)) continue;

                String word=beginWord.substring(0,i)+c+beginWord.substring(i+1);
                if(mp.containsKey(word) && !visit.contains(mp.get(word))){
                    //queue and visit set stores the index
                    q.add(mp.get(word));
                    visit.add(mp.get(word));
                }
            }
        }

        //bfs
        while(!q.isEmpty()){
            res++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int node=q.poll();

                //check if the current node is the endWord
                if(wordList.get(node).equals(endWord)) return res;

                //otherwise add its neighbor in the queue and mark them visited
                for(int nei: adj.get(node)){
                    if(!visit.contains(nei)){
                        visit.add(nei);
                        q.add(nei);
                    }
                }
            }
        }

        return 0;

    }
}
