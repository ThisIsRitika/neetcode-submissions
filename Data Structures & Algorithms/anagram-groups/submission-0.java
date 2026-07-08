class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();

        for(String str : strs){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String sorted=new String(arr);

            map.putIfAbsent(sorted, new ArrayList<String>());
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
