class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] freq=new int[26];

        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }

        int left=0;
        for(int right=s1.length();right<s2.length()+1;right++){
            int[] windowFreq=new int[26];
            String sub=s2.substring(left,right);
            for(int i=0;i<sub.length();i++){
                char ch=sub.charAt(i);
                windowFreq[ch-'a']++;
            }

            if(Arrays.equals(freq,windowFreq)) return true;
            else left++;
            
        }

        return false;

    }
}
