package Solution201to300;
//208
public class Trie {
    private Trie[] children;
    private boolean isEnd;
    public Trie(){
        children=new Trie[26];
        isEnd=false;
    }
    public  void insert(String word){
        Trie node=this;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            int index=ch-'a';
            if(node.children[index]==null){
                node.children[index]=new Trie();
            }
            node=node.children[index];
        }
        node.isEnd=true;
    }
    public boolean search(String word){
        Trie node=searchPrefix(word);
        return node!=null&&node.isEnd;
    }
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }
    public Trie searchPrefix(String word){
        Trie node=this;
        for(int i=0;i<word.length();i++){
            int a=word.charAt(i)-'a';
            if(node.children[a]==null){
                return null;
            }
            node=node.children[a];
        }
        return node;
    }
}
