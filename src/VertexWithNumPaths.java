/**
 * Created by TheLetch on 24/02/2017.
 */
public class VertexWithNumPaths<T> extends Vertex {
    private int numPaths;

    public VertexWithNumPaths(long id) {
        super(id);
        numPaths=0;
    }

    public int getNumPaths() {
        return numPaths;
    }

    public void setNumPaths(int numPaths) {
        this.numPaths = numPaths;
    }
}
