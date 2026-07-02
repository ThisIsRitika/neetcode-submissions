class Solution {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;

        while(start<end){
            if(!(Character.isLetterOrDigit(s.charAt(start)))){
                start=start+1;
                continue;
            }
            if(!(Character.isLetterOrDigit(s.charAt(end)))){
                end=end-1;
                continue;
            }
            if(Character.toLowerCase(s.charAt(start))==Character.toLowerCase(s.charAt(end))){
                start++;
                end--;
            }else return false;
        }

        return true;
    }
}
