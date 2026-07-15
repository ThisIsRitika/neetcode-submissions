class Solution {
    public String minWindow(String s, String t) {
        int m=s.length();
        int n=t.length();

        HashMap<Character, Integer> map=new HashMap<>();

        int minLen=Integer.MAX_VALUE;
        int stIdx=-1;
        int count=0;

        for(int i=0;i<n;i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        int left=0;
        int right=0;

        while(right<m){
            if(map.getOrDefault(s.charAt(right),0)>0){
                count=count+1;
            }

            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)-1);

            while(count==n){
                if(right-left+1<minLen){
                    minLen=right-left+1;
                    stIdx=left;
                }

                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
                if(map.getOrDefault(s.charAt(left),0)>0) count=count-1;
                left++;
                
            }

            right++;
        }

        if(stIdx==-1) return "";

        return s.substring(stIdx, stIdx+minLen);
    }
}
