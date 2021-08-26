public class Treenode {
    public boolean isValidSerialization(String preorder) {
        if(preorder.charAt(0)=='#'&&preorder.length()>1){
            return false;
        }
        int ru=1;
        for(int i=0;i<preorder.length();i++){
            if(Character.isDigit(preorder.charAt(i))){
                while(i+1<preorder.length()&&Character.isDigit(preorder.charAt(++i))){

                }
                ru-=1;
                ru+=2;
            }
            if(preorder.charAt(i)=='#'){
                ru-=1;
            }
            if(ru<0){
                return false;
            }
            if(i!=preorder.length()-1&&ru==0){
                return false;
            }
        }
        if(ru!=0){
            return false;
        }
       return true;
    }
}
