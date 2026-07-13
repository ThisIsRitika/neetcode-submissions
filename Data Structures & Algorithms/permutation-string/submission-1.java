class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] sArr=s1.toCharArray();
        Arrays.sort(sArr);

        for(int i=0;i<s2.length()-s1.length()+1;i++){
            for(int j=i;j<i+s1.length();j++){
                String sub=s2.substring(i,j+1);
                if(sub.length()==s1.length()){
                    char[] subArr=sub.toCharArray();
                    Arrays.sort(subArr);
                    if(Arrays.equals(sArr,subArr)) return true;
                }
                
            }
        }

        return false;
    }
}
