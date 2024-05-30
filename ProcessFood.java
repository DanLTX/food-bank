public class ProcessFood extends FoodItem
{
    private String foodType;
    private String packaging; 
    private ExpirationDate expDate;
    
    public ProcessFood()//default constructor
    {
        super();
        foodType = null;
        packaging = null;
        expDate = new ExpirationDate();
    }
    
    public ProcessFood(String n, String ic, String p, String nf, int q, String foodType, String packaging, int ed, int em, int ey)//normal constructor
    {
        super(n,ic,p,nf,q);
        this.foodType = foodType;
        this.packaging = packaging;
        expDate = new ExpirationDate(ed,em,ey);
    }
    
    //accessor methods
    public String getFoodType(){return foodType;}
    public String getPackaging(){return packaging;}
    
    //mutator method
    public void setDetails(String newFoodType, String newPackaging)
    {
        foodType = newFoodType;
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
    public String toString()
    {
        return super.toString() + "\nType Of Food\t: " + foodType + "\nPackaging\t: " + packaging + expDate.toString();
    }
}