class Solution {
    
    static class Trie{
        Trie[] children;
        boolean isEnd;
        String word;
        
        Trie(){
            children=new Trie[26];
            isEnd=false;
            word=null;
        }
        
    }

    public Trie insert(String[] words){
        Trie root=new Trie();

        for(String word:words){
            Trie node=root;

            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(node.children[idx]==null) node.children[idx]=new Trie();

                node=node.children[idx];
            }

            node.isEnd=true;
            node.word=word;                
        }

        return root;
            
    }

    

    private void dfs(char[][] board,int i, int j, Trie root, List<String> ans){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;

        char ch=board[i][j];

        //already visited
        if(ch=='#') return;

        int idx=ch-'a';

        //character not in trie
        if(root.children[idx]==null) return;

        root=root.children[idx];

        if(root.isEnd){
            ans.add(root.word);
            root.isEnd=false;//to avoid duplicate words in ans 
        }

        //mark visited
        board[i][j]='#';

        //neighbour nodes
        dfs(board,i+1,j,root,ans);
        dfs(board,i-1,j,root,ans);
        dfs(board,i,j+1,root,ans);
        dfs(board,i,j-1,root,ans);

        //backtrack
        board[i][j]=ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root=insert(words);

        List<String> ans = new ArrayList<>();

        int m=board.length;
        int n=board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
       
    }
}
