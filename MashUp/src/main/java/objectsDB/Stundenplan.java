package objectsDB;

import java.sql.Time;

public class Stundenplan {
    private int user_id;
    private int day;
    private Time start_time;
    private Time end_time;
    private String lesson;

    public Stundenplan() {
    }

    public Stundenplan(int user_id, int day, Time start_time, String lesson) {
        this.user_id = user_id;
        this.day = day;
        this.start_time = start_time;
        this.lesson = lesson;
        this.end_time = new Time(start_time.getHours(), start_time.getMinutes() + 45, start_time.getSeconds());
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDayInt(){
        return day;
    }

    public String getDayString() {

        switch (day){
            case 1:
                return "Montag";
            case 2:
                return  "Dienstag";
            case 3:
                return "Mittwoch";
            case 4:
                return "Donnerstag";
            case 5:
                return "Freitag";
            case 6:
                return "Samstag";
            default:
                return "Sonntag";
        }
    }

    public void setDayInt(int day) {
        this.day = day;
    }

    public void setDayString(String day){
        switch (day){
            case "Montag":
                this.day = 1;
                break;
            case "Dienstag":
                this.day = 2;
                break;
            case "Mittwoch":
                this.day = 3;
                break;
            case "Donnerstag":
                this.day = 4;
                break;
            case "Freitag":
                this.day = 5;
                break;
            case "Samstag":
                this.day = 6;
                break;
            default:
                this.day = 7;
                break;
        }
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }
}
