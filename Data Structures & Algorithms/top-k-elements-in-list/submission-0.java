class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        int result[]=new int[k];

        for(int i=0;i<k;i++){
            int max=maxKey(map);
            result[i]=max;
            map.remove(max);
        }

        return result;
    }

    private int maxKey(HashMap<Integer, Integer> map){
        int maxVal=0;
        int max=0;
        for(int key : map.keySet()){
            if(map.get(key)>maxVal){
                maxVal=map.get(key);
                max=key;
            }
        }

        return max;
    }
}
