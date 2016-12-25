package View.InputStrategy;

import java.util.List;

/**
 * Created by Nathnael on 6/2/2016.
 */
public interface InputSource {
    List<String> getOrigins();
    List<String> getDestinations();
    List<String> getPrice();
    List<String> getDistance();
    List<String> getStartTime();
    List<String> getEndTime();

}
