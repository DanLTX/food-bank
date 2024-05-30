public class Drink extends FoodItem
{
    private String drinkType; //eg: dairy, non-dairy, soda, juice
    private String packaging; //eg: can-1, bottle-2, carton-12
    private ExpirationDate expDate;
    
    public Drink()//default constructor
    {
        super();
        drinkType = null;
        packaging = null;
        expDate = new ExpirationDate();
    }
    
    public Drink(String n, String ic, String p, String nf, int q, String t, String pg, int ed, int em, int ey)//normal constructor
    {
        super(n,ic,p,nf,q);
        drinkType = t;
        packaging = pg;
        expDate = new ExpirationDate(ed,em,ey);
    }
    
    //accessor methods
    public String getDrinkType(){return drinkType;}
    public String getPackaging(){return packaging;}
    
    //mutator method
    public void setDetails(String newDrinkType, String newPackaging)
    {
        drinkType = newDrinkType;
        packaging = newPackaging;
    }
    
    //calculate expiration date to know if the product is still safe to eat
    public String calExpirationDate()
    {
        if(expDate.getExpYear() <  2023)
        {
            return "\n" + toString();
        }
        
        else if(expDate.getExpYear() ==  2023)
        {
            if(expDate.getExpMonth() < 07)
            {
                return "\n" + toString();
            }
            else if(expDate.getExpMonth() == 07)
            {
                if(expDate.getExpDay() < 19)
                {
                    return "\n" + toString();
                }
            }
        }
        
        return " ";
    }
    
    //display method
    public String toString(){
        return super.toString() + "\nType of Drink\t: " + drinkType + "\nPackaging\t: " + packaging + expDate.toString();
    }
}