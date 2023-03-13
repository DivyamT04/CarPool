package comm.example.divyamthapliyal.carpool;

public class Users {
    private String Age;
    private String Date;
    private String From;
    private String Name;
    private String SeatsAvailable;
    private String Time;
    private String To;
    private String Contact;

    public Users(){

    }

    public Users(String Age ,String Date , String From , String Name , String SeatsAvailable , String Time , String To, String contact ){
        this.Age = Age;
        this.Date = Date;
        this.From = From;
        this.Name = Name;
        this.SeatsAvailable = SeatsAvailable;
        this.Time = Time;
        this.To = To;
        this.Contact = contact;
    }

    public String getAge(){
        return Age;
    }
    public void setAge(String age){
        Age = Age;
    }

    public String getDate(){
        return Date;
    }
    public void setDate(String date){
        Date = date;
    }

    public String getFrom(){
        return From;
    }
    public void setFrom(String from){
        From = from;
    }

    public String getName(){
        return Name;
    }
    public void setName(String name){
        Name = name;
    }

    public String getSeatsAvailable(){
        return SeatsAvailable;
    }
    public void setSeatsAvailable(String seatsAvailable){
        SeatsAvailable = seatsAvailable;
    }

    public String getTime(){
        return Time;
    }
    public void setTime(String time){
        Time = time;
    }

    public String getTo(){
        return To;
    }
    public void setTo(String to){
        To = to;
    }

    public String getContact() {
        return Contact;
    }
    public void setContact(String contact){
        Contact = contact;
    }
}
