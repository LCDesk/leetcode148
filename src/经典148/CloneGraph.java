package 经典148;

import java.util.*;


//DFS+新旧节点映射
public class CloneGraph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> vistied = new HashMap<>();
        vistied.put(node, new UndirectedGraphNode(node.label));
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!vistied.containsKey(neighbor)) {
                    vistied.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    stack.push(neighbor);
                }
                vistied.get(cur).neighbors.add(vistied.get(neighbor));
            }
        }
        return vistied.get(node);
    }


}
