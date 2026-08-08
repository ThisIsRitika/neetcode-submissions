class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return new ArrayList<>();
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        List<String> result=new ArrayList<>();
        StringBuilder curr=new StringBuilder();
        backtrack(digits, 0, map, curr, result);

        return result;

    }

    private void backtrack(String digits, int idx, HashMap<Integer,String> map, StringBuilder curr, List<String> result){
        if(idx==digits.length()){
            result.add(new String(curr));
            return;
        }

       
        int digit=digits.charAt(idx)-'0';
        String characters=map.get(digit);
        for(int j=0;j<characters.length();j++){
            curr.append(characters.charAt(j));
            backtrack(digits,idx+1,map,curr,result);
            curr.deleteCharAt(curr.length()-1);
        }
        
    }
}
