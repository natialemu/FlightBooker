package Model.Tools;

/**
 * Created by Nathnael on 6/2/2016.
 */
public interface PriorityQueue {
    Void insert(int vertex);
    int deleteMin();
    boolean isEmpty();
    boolean contains(int vertex);
    Void update(int vertex, double newWeight);
}
