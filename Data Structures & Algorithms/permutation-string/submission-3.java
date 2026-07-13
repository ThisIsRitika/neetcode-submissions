class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m=s1.length();
        int n=s2.length();

        if(m>n) return false;

        int freq1[]=new int[26];
        int freq2[]=new int[26];

        //initialise freq array for s1 and freq array of first window of s2
        for(int i=0;i<m;i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }

        //comapre first window
        if(Arrays.equals(freq1,freq2)) return true;

        //slide the window
        for(int right=m;right<n;right++){
            int left=right-m;

            freq2[s2.charAt(left)-'a']--;
            freq2[s2.charAt(right)-'a']++;

            if(Arrays.equals(freq1,freq2)) return true;
        }

        return false;
    }
}
