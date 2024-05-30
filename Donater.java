public class Donater
{
    private String name;
    private String icNum;
    private String phoneNum;
    
    public Donater()//default constructor
    {
        name = null;
        icNum = null;
        phoneNum = null;
    }
    
    public Donater(String name, String icNum, String phoneNum)//normal constructor
    {
        this.name = name;
        this.icNum = icNum;
        this.phoneNum = phoneNum;
    }
    
    //accessor methods
    public String getName(){return name;}
    public String getIcNum(){return icNum;}
    public String getPhoneNum(){return phoneNum;}
    
    //mutator method
    public void setDetails(String newName, String newIcNum, String newPhoneNum)
    {
        name = newName;
        icNum = newIcNum;
        phoneNum = newPhoneNum;
    }
    
    //mutator method for phone number
    public void setPhoneNum(String np){phoneNum = np;}
    
    //display method
    public String toString()
    {
        return "\nName\t\t: " + name + "\nIC Number\t: " + icNum + "\nPhone Number\t: "
        + phoneNum ;
    }
}