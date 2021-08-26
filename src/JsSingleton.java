public class JsSingleton {
    //private JsSingleton js;
    private JsSingleton(){

    }
    public static JsSingleton getInstance(){
        return Iner.instance;
    }
    private static class Iner{
        public static JsSingleton instance=new JsSingleton();
    }
}
