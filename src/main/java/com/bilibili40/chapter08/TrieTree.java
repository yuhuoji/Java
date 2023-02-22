package com.bilibili40.chapter08;

/**
 * @date 2022-11-26 10:30
 * 前缀树
 * 前缀树是N叉树的一种特殊形式。通常来说，一个前缀树是用来存储字符串的。前缀树的每一个节点代表一个字符串（前缀）。
 * 每一个节点会有多个子节点，通往不同子节点的路径上有着不同的字符。子节点代表的字符串是由节点本身的原始字符串，以及通往该子节点路径上所有的字符组成的。
 */
public class TrieTree {
    //前缀树节点
    private class TrieNode {
        public int pass; //有几个字符串通过当前节点
        public int end; //当前节点是几个字符串的终止节点
        public TrieNode[] nexts; //26个英文字母用数组，汉字可用HashMap<Char,Node> nexts

        public TrieNode() {
            pass = 0;
            end = 0;
            nexts = new TrieNode[26]; //任何一个节点都可能有26个子节点，对应26个英文字母
        }
    }

    //前缀树
    public class Trie {
        private TrieNode root; //根节点，根节点的pass表示有多少字符串以空作为前缀（树中有多少字符串）

        public Trie() {
            root = new TrieNode();
        }

        //插入一个字符串
        public boolean insert(String word) {
            //添加失败 TODO ??? 允许插入哪些字符
            if (word == null) {
                return false;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0; //a~z -> 0~25
            //遍历字符串数组并添加
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a'; //对应ASCII-a的ASCII
                if (node.nexts[index] == null) { //不存在该节点，需要新建
                    node.nexts[index] = new TrieNode();
                }
                //已存在该节点
                node = node.nexts[index]; //向下继续查询
                node.pass++;
            }
            node.end++;
            return true;
        }

        //统计一个字符串的次数
        public int search(String word) {
            //查找为空
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = root; //从根节点开始查找
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) { //该字符串未添加过
                    return 0;
                }
                node = node.nexts[index];
            }
            //该字符串存在，返回叶节点的end
            return node.end;
        }

        //所有加入的字符串中，有几个是以pre为前缀的
        public int prefixNumber(String pre) {
            //查找为空
            if (pre == null) {
                return 0;
            }
            char[] chars = pre.toCharArray();
            TrieNode node = root; //从根节点开始查找
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) { //该字符串未添加过
                    return 0;
                }
                node = node.nexts[index];
            }
            //该字符串存在，返回最终节点的pass
            return node.pass;
        }

        //删除一个字符串
        public boolean delete(String word) {
            if (search(word) != 0) { //添加过的字符串才能删除
                char[] chars = word.toCharArray();
                TrieNode node = root; //从根节点开始查找
                node.pass--; //根节点pass-1
                int index = 0;
                for (int i = 0; i < chars.length; i++) { //遍历字符串，中间每个节点的pass-1，最后一个基点的end-1
                    index = chars[i] - 'a';
                    node.nexts[index].pass--;
                    if (node.nexts[index].pass == 0) { //pass==0，后序节点都为空，jvm垃圾处理机制，释放内存
                        node.nexts[index] = null;
                        return true;
                    }
                    node = node.nexts[index]; //继续向下操作
                }
                node.end--; //叶节点end-1
                return true;
            } else { //字符串不存在，删除失败
                return false;
            }
        }

    }

}
