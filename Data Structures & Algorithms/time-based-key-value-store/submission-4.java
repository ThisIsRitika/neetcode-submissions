class TimeMap {

    static class Pair{
        String value;
        int timestamp;

        public Pair(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }

    private HashMap<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair=new Pair(value,timestamp);
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(pair);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair> pairs=map.get(key); 
        int l=0;
        int r=pairs.size()-1;
        String value="";
        while(l<=r){
            int mid=(l+r)/2;
            int t=pairs.get(mid).timestamp;
            if(t==timestamp) return pairs.get(mid).value;
            else if(t<timestamp){
                value=pairs.get(mid).value;
                l=mid+1;
            }else r=mid-1;
        }

        return value;
    }
}
