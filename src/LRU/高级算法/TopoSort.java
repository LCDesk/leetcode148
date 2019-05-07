package LRU.高级算法;

import 经典148.LinkedListCycle;

import java.util.LinkedList;
import java.util.Queue;

public class TopoSort {
    class Graph {
        private int value;
        private LinkedList<Integer>[] adj;//邻接表

        public Graph(int value) {
            this.value = value;
            this.adj = new LinkedList[value];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList();
            }
        }

        //s->t的一条边
        public void addEdge(int s, int t) {
            adj[s].add(t);
        }

        //每次打印入度为0的顶点
        public void topoSortByKahn() {
            int[] inDegree = new int[value];
            for (int i = 0; i < value; i++) {
                for (int j = 0; j < adj[i].size(); j++) {
                    int w = adj[i].get(j);
                    inDegree[w]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                int p = queue.poll();
                System.out.print("->" + p);
                for (int i = 0; i < adj[p].size(); i++) {
                    int w = adj[p].get(i);
                    inDegree[w]--;
                    if (inDegree[w] == 0) {
                        queue.offer(w);
                    }
                }
            }
        }


    }

}
