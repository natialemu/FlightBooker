package Model.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nathnael on 6/2/2016.
 */
public class SpecialPQ implements PriorityQueue {
    HashMap<Integer,Double> vertexToWeight;
    List<Integer> vertices;

    public SpecialPQ()
    {
        vertexToWeight = new HashMap<>();
        vertices =  new ArrayList<>();
    }
    @Override
    public Void insert(int vertex) {
        vertices.add(vertex);
        setDefaultPriority(vertex);
        bubbleUp(0,vertices.size()-1);
        return null;
    }

    @Override
    public int deleteMin() {
        int min = vertices.get(0);
        vertices.add(0,vertices.get(vertices.size()-1));
        vertices.add(vertices.size()-1,min);
        vertices.remove(vertices.get(vertices.size()-1));
        bubbleDown(0,vertices.size()-1);
        return min;
    }

    @Override
    public boolean isEmpty() {
        return vertices.size() == 0;
    }

    @Override
    public boolean contains(int vertex) {
        for(int i = 0; i < vertices.size();i++)
        {
            if(vertices.get(i) == vertex){
                return true;
            }
        }
        return false;
    }

    public Void update(int vertex, double newWeight)
    {

        if(vertexToWeight.containsKey(vertex)){
            double vertexWeight = newWeight; //vertexToWeight.get(vertex);
            vertexToWeight.put(vertex,newWeight);
            int vertexIndex = vertices.indexOf(vertex);
            if(vertexWeight < vertexToWeight.get(vertices.get((vertexIndex-1)/2)) && vertexIndex > 0){
                bubbleUp(0,vertexIndex);
            } else{
                bubbleDown(vertexIndex,vertices.size()-1);
            }
        }
        return null;
    }

    private Void setDefaultPriority(int vertex)
    {
        vertexToWeight.put(vertex,Double.POSITIVE_INFINITY);
        return null;
    }

    //start from last element
    private Void bubbleUp(int root, int bottom)
    {


        while(vertexToWeight.get(vertices.get(bottom)) < vertexToWeight.get(vertices.get((bottom-1)/2)) && bottom > root){
            int temp = vertices.get(bottom);
            vertices.add(bottom,vertices.get((bottom-1)/2));
            vertices.add((bottom-1)/2,temp);
            bottom = (bottom-1)/2;
        }
        return null;
    }

    //start from root
    private Void bubbleDown(int root, int bottom)
    {
        if(root == 0 && bottom == 0){
            return null;

        }
        while((vertices.get(root) > vertices.get(2*root+1) && (2*root+1)<bottom) || (vertices.get(root) > vertices.get(2*root+2) && 2*root+2 < bottom)){
            if(vertices.get(2*root+2) < vertices.get(2*root+1)){
                int temp = vertices.get(root);
                vertices.add(root,vertices.get(2*root+2));
                vertices.add(2*root+2,temp);
                root = 2*root+2;

            }
            else{
                int temp = vertices.get(root);
                vertices.add(root,vertices.get(2*root+1));
                vertices.add(2*root+1,temp);
                root = 2*root+1;
            }
        }
        return null;
    }

}
