class TimeMap {
    // A helper class to bundle the value and timestamp together securely
    class Data {
        String value;
        int timestamp;
        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, ArrayList<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        
        ArrayList<Data> list = map.get(key);
        int left = 0;
        int right = list.size() - 1;
        String result = "";
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (list.get(mid).timestamp <= timestamp) {
                // This is a valid candidate, but there might be a closer one to the right
                result = list.get(mid).value;
                left = mid + 1; 
            } else {
                // The timestamp is too large, search the left half
                right = mid - 1; 
            }
        }
        return result;
    }
}