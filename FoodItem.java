public abstract class FoodItem
{
    private String nameFood;
    private int quantity;
    private Donater donater;
    
    public FoodItem()//default constructor
    {
       donater = new Donater(); 
       nameFood = null;
       quantity = 0;
    }
    
    public FoodItem(String n, String ic, String p, String nf, int q)//normal constructor
    {
        donater = new Donater(n,ic,p);
        nameFood = nf;
        quantity = q;
    }
    
    //accessor method
    public String getNameFood(){return nameFood;}
    public int getQuantity(){return quantity;}
    public Donater getDonater(){return donater;}
    public String getName(){return donater.getName();}
    
    //mutator method
    public void setDetails(String newN, String newIc, String newP, String newNameFood, int newQuantity)
    {
        donater.setDetails(newN, newIc, newP);
        nameFood = newNameFood;
        quantity = newQuantity;
    }
    
    //abstract method
    public abstract String calExpirationDate();
    
    //mutator method for phone number
    public void setPhoneNum(String np){donater.setPhoneNum(np);}
    
    //display method
    public String toString()
    {
        return donater.toString() + "\nFood Donated\t: " + nameFood + "\nQuantity\t: " + quantity;
    }
}