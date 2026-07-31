class WordDictionary {

    WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children=new WordDictionary[26];
        isEnd=false;
    }

    public void addWord(String word) {
        WordDictionary node=this;
    
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            
            if(node.children[idx]==null){
                node.children[idx]=new WordDictionary();
            }

            node=node.children[idx];
        }

        node.isEnd=true;

    }

    public boolean search(String word) {
        return helperSearch(this, word, 0);
    }

    private boolean helperSearch(WordDictionary node, String word, int i){
        if(i==word.length()) return node.isEnd;

        char ch=word.charAt(i);

        if(ch=='.'){
            for(int j=0;j<26;j++){
                if(node.children[j]!=null){
                    if(helperSearch(node.children[j],word,i+1)) return true;
                }
            }

            return false;
        }else{
            int idx=ch-'a';
            if(node.children[idx]==null) return false;

            return helperSearch(node.children[idx],word,i+1);
        }
    }
}
