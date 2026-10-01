class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int len=0;
        int maxLen=0;
        String res="";
        for(int left=0;left<n;left++){
            for(int right=left+1;right<n+1;right++){
                String sub=s.substring(left,right);
                if(palindrome(sub)){
                    len=sub.length();
                    if(len>maxLen){
                        maxLen=len;
                        res=sub;
                    }
                }
                
            }
        }

        return res;
    }

    private boolean palindrome(String str){
        int left=0;
        int right=str.length()-1;
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
