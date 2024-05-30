public class CookedFood extends FoodItem
{
    private int preparationTime; //eg:08,21,14 using 24 hours system
    private String [] ingredients = new String[20]; //data member of type arrray
    private String servingSize;
    
    public CookedFood()//default constructor
    {
        super();
        preparationTime = 0;
        for(int i = 0; i < ingredients.length; i++)
            ingredients[i] = null;
        servingSize = null;
    }
    
    public CookedFood(String n, String ic, String p, String nf, int q, int t, String[] ig, String s)//normal constructor
    {
        super(n,ic,p,nf,q);
        preparationTime = t;
        for(int i = 0; i < ig.length; i++)
            ingredients[i] = ig[i];
        servingSize = s;
    }
    
    //accessor method
    public int getPreparationTime(){return preparationTime;}
    public String[] getingredients(){return ingredients;}
    public String getServingSize(){return servingSize;}
    
    //mutator method
    public void setDetails(int newPreparationTime, String[] newIngredients, String newServingSize)
    {
        preparationTime = newPreparationTime;
        for(int i = 0; i < ingredients.length; i++)
            ingredients[i] = newIngredients[i];
        servingSize = newServingSize;
    }
    
    //calculate preparation time to know if the product is still safe to eat
    public String calExpirationDate()
    {
        int currentTime = 13; //24 hour system
        int maxHour = 6;
        int timeleftH = currentTime - preparationTime;
        
        if(timeleftH > maxHour || timeleftH < 0)
            return "\n" + toString();
        
        else
            return " ";
            //return "\nAll The Food Is Not Expirated!";
    }
    
    //display method
    public String toString()
    {
        String output = super.toString() + "\nPreparation Time: " + preparationTime + ":00" + "\nServing Size\t: " + servingSize;
        for(int i = 0; i < ingredients.length; i++)
            {    
                if(ingredients[i] == null)
                    break;
                output += "\nIngredients "+ (i+1) + "\t: " +ingredients[i];
            }
        return output;
        //return super.toString() + "\nPreparation Time: " + preparationTime + "\nIngredients: " + ingredients + "\nServing Size: " + servingSize;
    }
}