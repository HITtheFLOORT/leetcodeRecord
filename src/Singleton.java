public class Singleton {
    private static volatile Singleton ton;
    private Singleton(){}
    public static Singleton getonstance(){
        if(ton==null){
            ton =new Singleton();//不可串形化
        }
        return ton;
    }
    public static Singleton syngetinstance(){
        if(ton==null){
            synchronized (Singleton.class){
                if(ton==null){
                    ton =new Singleton();
                }
            }
        }
        return ton;
    }
}
