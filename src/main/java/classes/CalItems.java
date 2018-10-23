package classes;

import com.google.api.services.calendar.model.EventDateTime;

public class CalItems {
    private String title;
    private String time;
    private String owner;   // This will be the CalendarID
    private String color;


    public CalItems(String title, String time, String owner, String color){
        super();
        this.title = title;
        //this.time = time;
        setTime(time);
        this.owner = owner;
        this.color = color;
    }

    public CalItems(){
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getTime(){return time;
    }

    public void setTime (String time){
        String stringDate = time;
        // System.out.println("the beginning value of startTime: "+this.startTime);
        //  stringDate = this.startTime.getDate().toString();
        //  System.out.println("the value of startTime after toString: "+this.startTime);
        System.out.println("Inside CalItems this.time value: " + time);
        System.out.println("Length value: "+ time.length());
        if(time.length()==21){
            // do nothing it's an all day event
            stringDate = "ALL DAY EVENT";
            System.out.println("ALL DAY EVENT");
        }
        else
        {
            // need to extract characters 24-28
            System.out.println("String value: " + stringDate);
            stringDate = String.valueOf(stringDate.substring(24,29));
            System.out.println("String value at character 24-28: " + stringDate);
        }

        this.time = stringDate;
    }

    public String getOwner(){
        return owner;
    }
    public void setOwner(String owner){
        this.owner = owner;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
}
