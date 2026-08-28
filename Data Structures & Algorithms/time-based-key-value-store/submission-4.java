class TimeMap {
    private HashMap<String,ArrayList<Integer>> center =new HashMap<>();
    private HashMap<Integer,String>  time=new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        center.putIfAbsent(key,new ArrayList<>());
        center.get(key).add(timestamp);
        time.put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(center.containsKey(key) && center.get(key).contains(timestamp))
        {
            return time.get(timestamp);
        }
        else if(center.containsKey(key) && !center.get(key).isEmpty())
        {   
            for(int i:center.get(key))
            {
                if(i<=timestamp)
                    break;
                else
                    return "";
            }
            while(!center.get(key).contains(timestamp))
                timestamp--;
            return time.get(timestamp);
        }
        return "";
    }
}
