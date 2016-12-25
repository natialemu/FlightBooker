package Model.Tools;

/**
 * Created by Nathnael on 6/10/2016.
 */
public class Time implements TimeInterface{
    private static final int SEC_IN_HOUR  = 3600;
    private static final int SEC_IN_MIN = 60;
    private int hour;
    private int minute;
    private int second;
    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    public Time(int hour, int minute)
    {
        this.hour = hour;
        this.minute = minute;
        second = 0;
    }
    @Override
    public Time getTime() {
        return new Time(hour, minute, second);
    }
    @Override
    public int getHour() {
        return hour;
    }
    @Override
    public int getMinute() {
        return minute;
    }
    @Override
    public int getSecond() {
        return second;
    }
    @Override
    public boolean compareTo(Time t) {
        if(!(t instanceof Time)){
            return false;
        }
        else if(this.hour != t.getHour()){
            if(this.hour > t.getHour()){
                return true;
            }
            else{
                return false;
            }
        } else if(this.minute != t.getMinute()) {
            if (minute > t.getMinute()) {
                return true;
            }
            else {
                return false;
            }
        } else{
            if (second > t.getSecond()) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    @Override
    public int difference(Time t) {
        int totalSeconds1 = hour*SEC_IN_HOUR + minute*SEC_IN_MIN + second;
        int totalSeconds2 = t.getHour()*SEC_IN_HOUR + t.getMinute()*SEC_IN_MIN + t.getSecond();
        return Math.abs(totalSeconds2 - totalSeconds1);
    }
}
