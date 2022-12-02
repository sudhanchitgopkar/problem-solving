class ParkingSystem {
    int [] cap = new int [3];

    public ParkingSystem(int big, int medium, int small) {
        cap[0] = big;
        cap[1] = medium;
        cap[2] = small;
    } //constructor
    
    public boolean addCar(int carType) {
        return --cap[--carType] >= 0; 
    } //add
} //ParkingSystem

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */