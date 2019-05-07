package LRU.高级算法;


//自己的优先队列实现，提供了update方法
public class PriorityQueue {
    private Dijkstra.Vertex[] nodes;
    private int count;//初始化数组的大小
    private int size = 0;//节点的大小

    public PriorityQueue(int count) {
        this.nodes = new Dijkstra.Vertex[count + 1];
        this.count = count;
    }

    //建堆，上滤
    public void add(Dijkstra.Vertex node) {

        size++;
        int i = size;
        Dijkstra.Vertex num = node;
        while (i != 1 && num.dist < nodes[i / 2].dist) {
            nodes[i] = nodes[i / 2];
            i = i / 2;
        }
        nodes[i] = num;
    }

    //弹出堆顶元素，下滤
    public Dijkstra.Vertex poll() {
        Dijkstra.Vertex res = nodes[1];
        nodes[1] = nodes[size--];
        int i = 1;
        int pos = 2 * i;
        Dijkstra.Vertex temp = nodes[i];
        while (pos <= size) {
            if (2 * i + 1 <= size && nodes[pos].dist > nodes[2 * i + 1].dist) {
                pos = 2 * i + 1;
            }
            if (temp.dist > nodes[pos].dist) {
                nodes[i] = nodes[pos];
                i = pos;
                pos = 2 * i;
            } else {
                break;
            }
        }
        nodes[i] = temp;
        return res;
    }

    public void upadte(Dijkstra.Vertex vertex) {
        for (int i = 1; i <= size; i++) {
            if (nodes[i].id == vertex.id) {
                nodes[i].dist = vertex.dist;
            }
        }
        for (int i = size / 2; i >= 1; i--) {
            int pos = 2 * i;
            if (pos != size && nodes[pos + 1].dist < nodes[pos].dist) {
                pos++;
            }
            if (nodes[i].dist > nodes[pos].dist) {
                Dijkstra.Vertex temp = nodes[i];
                nodes[i] = nodes[pos];
                nodes[pos] = temp;
            } else {
                break;
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Dijkstra.Vertex vertex = new Dijkstra().new Vertex(1, 7);
        Dijkstra.Vertex vertex1 = new Dijkstra().new Vertex(2, 6);
        Dijkstra.Vertex vertex2 = new Dijkstra().new Vertex(3, 5);
        Dijkstra.Vertex vertex3 = new Dijkstra().new Vertex(4, 4);
        Dijkstra.Vertex vertex4 = new Dijkstra().new Vertex(5, 3);
        Dijkstra.Vertex vertex5 = new Dijkstra().new Vertex(6, 2);
        PriorityQueue p = new PriorityQueue(6);
        p.add(vertex);
        p.add(vertex1);
        p.add(vertex2);
        p.add(vertex3);
        p.add(vertex4);
        p.add(vertex5);
        System.out.println(p.poll());
        vertex2.dist = 1;
        p.upadte(vertex2);

    }


}