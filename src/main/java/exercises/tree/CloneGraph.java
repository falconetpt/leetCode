package exercises.tree;


import java.util.*;
import java.util.stream.Collectors;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (Objects.isNull(node)) {
            return null;
        } else {

            return cloneGraph( node, new HashMap<>(  ) );
        }
    }

    private Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (Objects.isNull(node)) {
            return null;
        } else {
            Node result = new Node( node.val );

            if (map.containsKey( node.val )) {
                return map.get( node.val );
            } else {
                map.putIfAbsent( node.val, new Node( node.val ) );


                result.neighbors = node.neighbors.stream()
                        .map( n -> {
                            System.out.println(n.val + " : " + node.val);
                            System.out.println( map.getOrDefault( n.val, null ) );
                            return map.getOrDefault( n.val, cloneGraph( n, map ) );
                        } )
                        .collect( Collectors.toList());
                return result;
            }

        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
