import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by TheLetch on 23/02/2017.
 */
public class EfficientPathProfiling<T> {


    public void assignValuesToEdges(Graph<T> dag){
        ArrayDeque<Vertex<T>> tpg = new TopologicalSort<T>().sort(dag);
        List<Vertex<T>> rtsg = new TopologicalSort<T>().reverseSort(tpg) ;
        for (Vertex<T> v : rtsg){
            VertexWithNumPaths vpaths= (VertexWithNumPaths)v;
            if (vpaths.checkIfLeaf())
                vpaths.setNumPaths(1);
            else {
                vpaths.setNumPaths(0);
                List<Edge<T>> edgeList = vpaths.getEdgeList();
                for ( Edge<T> edge : edgeList){
                    EdgeWithValue edgeWithValue = (EdgeWithValue)edge;
                    vpaths.setNumPaths(vpaths.getNumPaths() + ((VertexWithNumPaths)edgeWithValue.getVertex2())
                            .getNumPaths());

                }
            }

        }
    }




    public void addExitEntryEdges(Graph<T> graph, int weight){
        Collection<Vertex<T>> edgeList = graph.getVertices();
        List<Vertex<T>> edges = new ArrayList<>();
        for (Vertex<T> vertex: edgeList){
            edgeList.add(vertex);
        }
        graph.addEdge(edges.get(edgeList.size()-1).getId(),edges.get(1).getId(),weight);
    }
}
