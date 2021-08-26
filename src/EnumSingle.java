public enum EnumSingle {//public static final
    INSTANCE;
    private EnumSingle(){//初始化一次
        System.out.println("init");
    }
    public static EnumSingle getInstance(){
        return INSTANCE;
    }

}
class User{
    private User(){}
    static enum Singleton{
        INSTANCE;
        private User user;
        private Singleton(){
            user=new User();
        }
        public  User getInstance(){
            return user;
        }
    }
    public static User getInstance(){
        return Singleton.INSTANCE.getInstance();
    }


}
