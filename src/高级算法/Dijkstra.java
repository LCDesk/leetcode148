package 高级算法;


import java.util.LinkedList;

//有向有权图中两个点之间的最短距离
public class Dijkstra {
    //实现Dijkstra算法
    public class Vertex {
        int id;//顶点编号
        int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }


    private class Edge {
        int sid;//边的起始编号
        int tid;//边的终止编号
        int w;//权重

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    //从顶点s->t的最短路径


    class Graph {
        private int value;//顶点个数
        LinkedList<Edge> adj[];//邻接表

        public Graph(int value) {
            this.value = value;
            this.adj = new LinkedList[value];
            for (int i = 0; i < adj.length; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int s, int t, int w) {//添加一条边
            adj[s].add(new Edge(s, t, w));
        }

        public void dijkstra(int s, int t) {
            //跟踪打印最短路径节点
            int[] predecessor = new int[this.value];
            Vertex[] vertexs = new Vertex[this.value];
            for (int i = 0; i < vertexs.length; i++) {
                vertexs[i] = new Vertex(i, Integer.MAX_VALUE);
            }
            //构建小顶堆
            PriorityQueue pq = new PriorityQueue(this.value);
            //标记是否进入过队列
            boolean[] inqueue = new boolean[this.value];
            vertexs[s].dist = 0;
            inqueue[s] = true;
            pq.add(vertexs[s]);
            //每次取出一个当前最短距离的点，然后计算他的下一条距离
            while (!pq.isEmpty()) {
                Vertex minVertex = pq.poll();
                if (minVertex.id == t) {
                    break;
                }
                for (int i = 0; i < adj[minVertex.id].size(); i++) {
                    Edge edge = adj[minVertex.id].get(i);
                    Vertex nextVertex = vertexs[edge.tid];
                    if (minVertex.dist + edge.w < nextVertex.dist) {
                        nextVertex.dist = minVertex.dist + edge.w;
                        predecessor[nextVertex.id] = minVertex.id;
                        if (inqueue[nextVertex.id]) {
                            pq.upadte(nextVertex);
                        } else {
                            pq.add(nextVertex);
                            inqueue[nextVertex.id] = true;
                        }
                    }
                }
            }
        }
    }
}
