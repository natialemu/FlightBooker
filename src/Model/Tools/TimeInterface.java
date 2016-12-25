package Model.Tools;

/**
 * Created by Nathnael on 6/10/2016.
 */
public interface TimeInterface {
    Time getTime();
    int getHour();
    int getMinute();
    int getSecond();
    boolean compareTo(Time t);
    int difference(Time t);



}
