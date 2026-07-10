class TimeMap {

    class Pair {
        int timestamp;
        String value;

        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    String[] setArr;
    //ArrayList<Pair> list;
    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        setArr=new String[3];
        map=new HashMap<>();
        //list=new ArrayList<Pair>;
    }
    
    public void set(String key, String value, int timestamp) {
        setArr[0]=key;
        setArr[1]=value;
        setArr[2]=String.valueOf(timestamp);
        
        //if the key doesn't exist add the key to the map with a new empty arraylist
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        
        //either the key already exist ao just put the values in the arraylist or the key is in the map after the if condition
        //in both cases add timestamp and value pair in the list
        map.get(key).add(new Pair(timestamp,value));
        
    }
    
    public String get(String key, int timestamp) {
        String value = "";
        if(map.containsKey(key)){
            ArrayList<Pair> list = map.get(key);
            int start=0;
            int end=list.size()-1;
            int mid=0;
            while(start<=end){
                mid=start+(end-start)/2;
                int t=list.get(mid).timestamp;//the timestamp of ith pair in the list is extracted
                if(t==timestamp) return list.get(mid).value;
                else if(t<timestamp){
                    value=list.get(mid).value;
                    start=mid+1;
                }else end=mid-1;
            }
        }
        
        return value;
        
    }
}
