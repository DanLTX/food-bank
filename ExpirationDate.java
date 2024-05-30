public class ExpirationDate
{
    private int expYear;
    private int expMonth;
    private int expDay;
    
    public ExpirationDate()//default constructor
    {
        expYear = 0;
        expMonth = 0;
        expDay= 0;
    }
    
    public ExpirationDate(int ed, int em, int ey)//normal constructor
    {
        expYear = ey;
        expMonth = em;
        expDay = ed;
    }
    
    //accessor method
    public int getExpYear(){return expYear;}
    public int getExpMonth(){return expMonth;}
    public int getExpDay(){return expDay;}
    
    //display method
    public String toString()
    {
        return "\nExpiration Date\t: " + expDay + "/" + expMonth + "/" + expYear;
    }
}