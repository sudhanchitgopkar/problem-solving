class UndergroundSystem {
    HashMap <Integer, CheckIn> checkins;
    HashMap <String, int[]> stationTimes;
    
    public UndergroundSystem() {
        checkins = new HashMap <> ();
        stationTimes = new HashMap <>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        //if (checkins.containsKey(id)) return;
        
        CheckIn newCheckIn = new CheckIn (stationName, t);
        checkins.put(id, newCheckIn);
    } //checkIn
    
    public void checkOut(int id, String stationName, int t) {
        //if (!checkins.containsKey(id)) return;
        String key = checkins.get(id).getStation() + "," +  stationName;
        int [] val = stationTimes.getOrDefault(key, new int [2]);
        val[0] += (t - checkins.get(id).getTime());
        val[1]++;
        
        stationTimes.put(key,val);
        
        checkins.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int [] travelTime = stationTimes.get(startStation+","+endStation);
        return Double.valueOf(travelTime[0])/Double.valueOf(travelTime[1]);
    }
}

class CheckIn {
    private String startStation;
    private int time;
    
    public CheckIn (String startStation, int time) {
        this.startStation = startStation;
        this.time = time;
    } //constructor
    
    public String getStation () {
        return startStation;
    } //getStation
    
    public int getTime () {
        return time;
    } //getStation
} //checkIn



/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */