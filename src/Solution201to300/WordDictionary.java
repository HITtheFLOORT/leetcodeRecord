package Solution201to300;

public class WordDictionary {

    // 前缀树节点
    private class TrieNode {
        TrieNode[] path;
        boolean end; // 是否存在以当前字符结尾的word
        public TrieNode() {
            path = new TrieNode[26]; // word中只含26个小写字母，准备26条路
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word == null || word.length() == 0) return;
        // 将word挂到前缀树上：
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            // 无路建路，有路上路：
            if (cur.path[c - 'a'] == null) cur.path[c - 'a'] = new TrieNode();
            cur = cur.path[c - 'a'];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        return search(word.toCharArray(), 0, root);
    }

    // DFS递归
    // 当前字符：chars[i]，当前来到的前缀树节点：cur
    // 返回：[i, ...]能否匹配上
    private boolean search(char[] chars, int i, TrieNode cur) {
        if (cur == null) return false;

        char curChar = chars[i];
        if (i == chars.length-1) { // 当前已是最后一个字符
            if (curChar != '.') { // 最后一个字符不是点，需要在前缀树上严格匹配（有对应的路，并且这条路上有end）
                return cur.path[curChar - 'a'] != null && cur.path[curChar - 'a'].end;
            } else { // 最后一个字符是点，只要存在一条有end的路即可匹配成功
                for (TrieNode path : cur.path) {
                    if (path != null && path.end) return true;
                }
                return false;
            }
        }
        // 当前不是最后一个字符，还有不止一个字符需要匹配：
        if (curChar != '.') { // 不是点，需要在前缀树上严格匹配（有对应的路，并且后续也能匹配上）
            return cur.path[curChar - 'a'] != null && search(chars, i+1, cur.path[curChar - 'a']);
        }
        // curChar == '.'，只要存在一条路，使得后续可以匹配上即可
        for (TrieNode path : cur.path) {
            if (search(chars, i+1, path)) return true;
        }
        return false;
    }
}
