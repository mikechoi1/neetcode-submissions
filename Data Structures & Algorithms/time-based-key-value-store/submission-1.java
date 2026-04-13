class ValueTime {
    public String value;
    public int timestamp;

    public ValueTime(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {

    Map<String, List<ValueTime>> hashmap;

    public TimeMap() {
        hashmap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        hashmap.putIfAbsent(key, new ArrayList<>());
        hashmap.get(key).add(new ValueTime(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<ValueTime> list = hashmap.getOrDefault(key, new ArrayList<>());
        int l = 0, r = list.size() - 1;
        String result = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            ValueTime vt = list.get(m);
            if (vt.timestamp <= timestamp) {
                result = vt.value;
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return result;
    }
}
