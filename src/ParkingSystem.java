public class ParkingSystem {
    public int a[]=new int[4];
    public ParkingSystem(int big, int medium, int small) {
        this.a[3]=big;
        this.a[2]=medium;
        this.a[1]=small;
    }

    public boolean addCar(int carType) {
        for(int i=0;i<this.a.length;i++){
            if(i>=4-carType&&a[i]-1>=0){
                a[i]--;
                return true;
            }else{
                continue;
            }
        }
        return false;
    }
}
