class Solution {
    public int characterReplacement(String s, int k) { 
        int n=s.length();
        int maxLen=0;

        int left=0;
        HashMap<Character, Integer> map=new HashMap<>();
        int maxFreq=0;
        
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);

            maxFreq=Math.max(maxFreq,map.get(ch));    
                
            int replacement=(right-left+1)-maxFreq;

            if(replacement<=k){
                maxLen=Math.max(maxLen,right-left+1);
            }else{
                char c=s.charAt(left);
                map.put(c,map.get(c)-1);
                left++;
                maxFreq=0;
            }
            
            
        }

        return maxLen;
    }
}
