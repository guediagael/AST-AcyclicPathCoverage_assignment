import java.util.*;

/**
 * Created by TheLetch on 23/02/2017.
 */
public class TopologicalSort<T> {


    public ArrayDeque<Vertex<T>> sort(Graph<T> graph) {
        ArrayDeque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getVertices()) {
            if (visited.contains(vertex)) {
                continue;
            }
            sortUtil(vertex,stack,visited);
        }
        return stack;
    }

    private void sortUtil(Vertex<T> vertex, Deque<Vertex<T>> stack, Set<Vertex<T>> visited) {
        visited.add(vertex);
        for(Vertex<T> childVertex : vertex.getAdjacentVertexList()){
            if(visited.contains(childVertex)){
                continue;
            }
            sortUtil(childVertex,stack,visited);
        }
        stack.offerFirst(vertex);
    }


    public List<Vertex<T>> reverseSort(ArrayDeque<Vertex<T>> sortedGraph){
        Deque<Vertex<T>> clonedSortedGraph = sortedGraph.clone();
        ArrayList<Vertex<T>> reversedGraph= new ArrayList<>();
        while (!clonedSortedGraph.isEmpty()) reversedGraph.add(clonedSortedGraph.pollLast());

        return reversedGraph;


    }
}
