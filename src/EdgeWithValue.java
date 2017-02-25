/**
 * Created by TheLetch on 24/02/2017.
 */
public class EdgeWithValue<T> extends Edge {

    private int value;




    public EdgeWithValue(Vertex start, Vertex end) {
        super(start, end, true);
    }

    public EdgeWithValue(Vertex start, Vertex end, int weight) {
        super(start, end, true, weight);
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
