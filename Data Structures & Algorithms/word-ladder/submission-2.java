class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord==endWord) return 0;

        wordList.add(beginWord);

        //pattern hashmap
        Map<String, List<String>> neiMap=new HashMap<>();
        for(String word : wordList){
            for(int j=0;j<word.length();j++){
                //generate pattern by replacing characters in word with a * one by one
                String pattern=word.substring(0,j)+'*'+word.substring(j+1);

                //check if the pattern already exists or not
                //add word to the list likewise
                //k means the pattern that doesn't already exists in the map
                //if pattern doesn't exist the operation occurs of creating a new arraylist
                //and the word is added
                neiMap.computeIfAbsent(pattern,k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visit=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        int res=1;
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(endWord)) return res;

                for(int j=0;j<word.length();j++){
                    String pattern=word.substring(0,j)+'*'+word.substring(j+1);

                    for(String neiWord : neiMap.getOrDefault(pattern, Collections.emptyList())){
                        if(!visit.contains(neiWord)){
                            visit.add(neiWord);
                            q.offer(neiWord);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}