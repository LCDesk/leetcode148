package 字符串匹配;


import java.util.LinkedList;
import java.util.Queue;

public class AC自动机 {
    class AcNode {
        char data;
        boolean isEndCharacter;
        AcNode[] children;
        AcNode fail;


        public AcNode(char data) {
            this.data = data;
            this.isEndCharacter = false;
            this.children = new AcNode[26];
        }
    }


    public void buildFailurePointer(AcNode head) {
        AcNode cur = head;
        cur.fail = null;
        Queue<AcNode> queue = new LinkedList<>();
        queue.offer(cur);
        while (!queue.isEmpty()) {
            AcNode p = queue.poll();
            for (int i = 0; i < p.children.length; i++) {
                AcNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == head) {
                    pc.fail = head;
                } else {
                    AcNode q = p.fail;
                    while (q != null) {
                        AcNode qc = q.children[i];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        } else {
                            q = q.fail;
                        }
                    }
                    if (q == null) {
                        pc.fail = head;
                    }
                }
                queue.offer(pc);
            }
        }
    }

    public void match(char[] text, AcNode head) {
        AcNode cur = head;
        for (char c : text) {
            int idx = c - 'a';
            while (cur.children[idx] != null && cur != head) {
                cur = cur.fail;
            }
            cur = cur.children[idx];
            if (cur == null) {
                cur = head;
            }
        }
    }


//    class AcNode {
//        boolean isEndingChar = false;
//        AcNode[] children = new AcNode[26];
//        char data;
//        AcNode fail;
//        int length = -1;
//
//        public AcNode(char data) {
//            this.data = data;
//        }
//    }
//
//    public void buildFailurePointer(AcNode head) {
//        Queue<AcNode> queue = new LinkedList<>();
//        head.fail = null;
//        queue.offer(head);
//        while (!queue.isEmpty()) {
//            AcNode p = queue.poll();
//            for (int i = 0; i < 26; i++) {
//                AcNode pc = p.children[i];
//                if (pc == null) {
//                    continue;
//                }
//                if (p == head) {
//                    pc.fail = head;
//                } else {
//                    AcNode q = p.fail;
//                    while (q != null) {
//                        AcNode qc = q.children[pc.data - 'a'];
//                        if (qc != null) {
//                            pc.fail = qc;
//                            break;
//                        }
//                        q = q.fail;
//                    }
//                    if (q == null) {
//                        pc.fail = head;
//                    }
//
//                }
//                queue.offer(pc);
//            }
//        }
//    }
//
//    public void match(char[] text, AcNode root) { // text 是主串
//        int n = text.length;
//        AcNode p = root;
//        for (int i = 0; i < n; ++i) {
//            int idx = text[i] - 'a';
//            while (p.children[idx] == null && p != root) {
//                p = p.fail; // 失败指针发挥作用的地方
//            }
//            p = p.children[idx];
//            if (p == null) p = root; // 如果没有匹配的，从 root 开始重新匹配
//            AcNode tmp = p;
//            while (tmp != root) { // 打印出可以匹配的模式串
//                if (tmp.isEndingChar) {
//                    int pos = i - tmp.length + 1;
//                    System.out.println(" 匹配起始下标 " + pos + "; 长度 " + tmp.length);
//                }
//                tmp = tmp.fail;
//            }
//        }
//    }

}
