class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) return 0;

        Set<String> words=new HashSet<>(wordList);
        Queue<String> qb=new LinkedList<>() , qe=new LinkedList<>();
        Map<String, Integer> fromBegin=new HashMap<>();
        Map<String, Integer> fromEnd=new HashMap<>();
        qb.add(beginWord);
        qe.add(endWord);
        //key -> word value -> steps
        fromBegin.put(beginWord,1);
        fromEnd.put(endWord,1);

        //size of words in the list
        int m=wordList.get(0).length();

        while(!qb.isEmpty() && !qe.isEmpty()){
            //with swap qe as qb if the length of qe is smaller
            //because we only expand the smaller queue
            //visually the queues are being expanded one by one
            if(qb.size()>qe.size()){
                //swap queues
                Queue<String> tempQ=qb;
                qb=qe;
                qe=tempQ;
                //also swap maps
                Map<String, Integer>temp=fromBegin;
                fromBegin=fromEnd;
                fromEnd=temp;
            }

            int size=qb.size();
            for(int i=0;i<size;i++){
                String word=qb.poll();
                int steps=fromBegin.get(word);
                for(int j=0;j<m;j++){
                    for(char c='a';c<='z';c++){
                        if(c==word.charAt(j)) continue;
                        String nei=word.substring(0,j)+c+word.substring(j+1);

                        if(!words.contains(nei)) continue;
                        if(fromEnd.containsKey(nei)) return steps+fromEnd.get(nei);
                        if(!fromBegin.containsKey(nei)){
                            fromBegin.put(nei,steps+1);
                            qb.add(nei);
                        }
                    }
                }
            }
        }

        return 0;
    }
}