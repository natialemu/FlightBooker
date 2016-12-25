package Model.Graphs;

import java.util.Date;

/**
 * Created by Nathnael on 6/2/2016.
 *
 *
 */
public interface DirectedEdge{
    Integer from();
    Integer to();

    Weight getWeight();



}
