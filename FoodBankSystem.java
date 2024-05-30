import java.io.*;
import java.util.*;

public class FoodBankSystem
{
    public static void main(String args[])throws Exception
    {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        
        try
        {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            PrintWriter pw = new PrintWriter("report.txt");
            
            FoodItem foodItem[] = new FoodItem[21];
            //Donater donater[] = new Donater[21];
            int i = 0;
            
            //block of codes
            String indata = null;
            pw.println("════════════════════════════════════════════");
            pw.println("\t\t[Donation Report]");
            pw.print("════════════════════════════════════════════");
            
            while((indata = br.readLine())!=null)
            {
                StringTokenizer st = new StringTokenizer(indata,";");
                
                String name = st.nextToken(); //eg: Siti, Hisyam, Rahim
                String icNum = st.nextToken();  //eg: 040103010743, 070912090113
                String phoneNum = st.nextToken();   //eg: 0112459875, 0198403927
                int option = Integer.parseInt(st.nextToken()); //eg: 1,2,3 (type of food donation)
                String nameFood = st.nextToken();   //eg: Baked Beans, Nasi Bujang
                int quantity = Integer.parseInt(st.nextToken()); //eg: 12, 5, 3
                
                
                if(option == 1)
                {
                    String drinkType = st.nextToken(); //eg: Soda, Mineral Water
                    String packaging = st.nextToken(); //eg: Can, Bottle, Carton
                    int expDay = Integer.parseInt(st.nextToken()); //eg; 12, 05, 28
                    int expMonth = Integer.parseInt(st.nextToken()); //eg: 01,07,11
                    int expYear = Integer.parseInt(st.nextToken()); //eg: 2023, 2030, 2024
                    
                    foodItem[i] = new Drink(name,icNum,phoneNum,nameFood,quantity,drinkType,packaging,expDay,expMonth,expYear);
                    pw.print("\n\n[Donater " + (i+1) + "]");
                    pw.print("\n════════════════════════════════════════════");
                    pw.print(foodItem[i].toString());
                }
                else if(option == 2)
                {
                    String foodType = st.nextToken();   //eg: Instant noodles, Cookie
                    String packaging = st.nextToken();  //eg: Can, Bag, Box
                    int expDay = Integer.parseInt(st.nextToken());  //eg; 12, 05, 28
                    int expMonth = Integer.parseInt(st.nextToken());    //eg: 01,07,11
                    int expYear = Integer.parseInt(st.nextToken()); //eg: 2023, 2030, 2024
                    
                    foodItem[i] = new ProcessFood(name,icNum,phoneNum,nameFood,quantity,foodType,packaging,expDay,expMonth,expYear);
                    pw.print("\n\n[Donater " + (i+1) + "]");
                    pw.print("\n════════════════════════════════════════════");
                    pw.print(foodItem[i].toString());
                }
                else if(option == 3)
                {
                    int preparationTime = Integer.parseInt(st.nextToken()); //eg: 7,13,17 using 24-hour system
                    int sizeIng = Integer.parseInt(st.nextToken()); //eg: 3,5 (amount of ingredients)
                    String ingredients[] = new String[sizeIng];
                    for(int j = 0; j < ingredients.length; j++)
                        ingredients[j] = st.nextToken();
                    String servingSize = st.nextToken(); //eg: Container, Tray
                    
                    foodItem[i] = new CookedFood(name,icNum,phoneNum,nameFood,quantity,preparationTime,ingredients,servingSize);
                    pw.print("\n\n[Donater " + (i+1) + "]");
                    pw.print("\n════════════════════════════════════════════");
                    pw.print(foodItem[i].toString());
                }
                
                i++;
            }
            pw.println("\n\n------------------------------------------------------");
            
            boolean ans = false;
            System.out.println("══════════════════════════════════════════════════════════════════");
            System.out.println("                    WELCOME TO FOOD BANK MANAGEMENT SYSTEM");
            System.out.println("══════════════════════════════════════════════════════════════════");
            while(!ans)
            {   
                System.out.println("\n[1] DISPLAY DETAILS OF CHOSEN FOOD CATEGORY");
                System.out.println("[2] UPDATE DONATER PHONE NUMBER");
                System.out.println("[3] DISPLAY QUANTITY OF EVERY FOOD CATEGORY");
                System.out.println("[4] DISPLAY LIST OF EXPIRED FOOD");
                System.out.println("[5] EXIT");
                System.out.print("\nCHOOSE TASK TO BE EXECUTED\t: ");
                int task = sc.nextInt();
                
                if(task==1)//if statement for display details of chosen food category
                {
                    System.out.print("\n[1-DRINK][2-PROCESS FOOD][3-COOKED FOOD]");
                    System.out.print("\nENTER CATEGORY OF FOOD TO BE DISPLAYED: ");
                    int searchFood = sc.nextInt();
                    for(int k = 0; k < foodItem.length; k++)
                    {
                        if(searchFood == 1)
                        {   
                            //Drink temp = (Drink)foodItem[i];
                            if(foodItem[k] instanceof Drink)
                                System.out.println(foodItem[k].toString());
                        }
                        
                        else if(searchFood == 2)
                        {   
                            if(foodItem[k] instanceof ProcessFood)
                                System.out.println(foodItem[k].toString());
                        }
                        
                        else if(searchFood == 3)
                        {   
                            if(foodItem[k] instanceof CookedFood)
                                System.out.println(foodItem[k].toString());
                        }
                    }
                }
                
                else if(task==2)//if for update donater phone number
                {
                    System.out.print("\n[UPDATE]");
                    System.out.print("\nPlease Enter Donater Name To Update Phone Number: ");
                    String Sname = sc.next();
                    System.out.print("Please Enter The New Phone Number: ");
                    String newPNum = sc.next();
                    boolean found = false;
                    for(int j = 0; j < foodItem.length; j++)
                    {
                        if(Sname.equalsIgnoreCase(foodItem[j].getName()))
                        {   
                            found = true;
                            foodItem[j].setPhoneNum(newPNum);
                            System.out.println("\nPHONE NUMBER IS SUCCESSFULLY UPDATED!");
                            System.out.println(foodItem[j].toString());
                            pw.print("\nUPDATED INFORMATION");
                            pw.print("\n\n[Donater " + (j+1) + "]");
                            pw.print(foodItem[j].toString());
                            break;
                        }
                        else if(j==19)
                            break;
                    }
                    
                    if(!found)
                    {
                        System.out.print("\nNAME NOT FOUND!");
                    }
                }
                
                else if(task==3)//if for quantity of food for each category
                {
                    int countD = 0;
                    int countDC = 0; //can
                    int countDB = 0; //bottle
                    int countDCR = 0; //carton
                    
                    int countP = 0;
                    int countPC = 0;   //can
                    int countPB = 0;   //bag
                    int countPBX = 0;  //box
                    
                    int countCF = 0;
                    int countCFC = 0;   //container
                    int countCFT = 0;   //tray
                    
                    for(int j = 0; j < foodItem.length; j++)
                    {
                        if(foodItem[j] instanceof Drink)
                        {
                            Drink temp = (Drink) foodItem[j];
                            if(temp.getPackaging().equalsIgnoreCase("Can"))
                                countDC += foodItem[j].getQuantity();
                            else if(temp.getPackaging().equalsIgnoreCase("Bottle"))
                                countDB += foodItem[j].getQuantity();
                            else if(temp.getPackaging().equalsIgnoreCase("Carton"))
                                countDCR += foodItem[j].getQuantity();  
                        }
                        
                        else if(foodItem[j] instanceof ProcessFood)
                        {
                            ProcessFood temp = (ProcessFood) foodItem[j];
                            if(temp.getPackaging().equalsIgnoreCase("Can"))
                                countPC += foodItem[j].getQuantity();
                            else if(temp.getPackaging().equalsIgnoreCase("Bag"))
                                countPB += foodItem[j].getQuantity();
                            else if(temp.getPackaging().equalsIgnoreCase("Box"))
                                countPBX += foodItem[j].getQuantity();
                        }
                        
                        else if(foodItem[j] instanceof CookedFood)
                        {
                            CookedFood temp = (CookedFood) foodItem[j];
                            if(temp.getServingSize().equalsIgnoreCase("Container"))
                                countCFC += foodItem[j].getQuantity();
                            else if(temp.getServingSize().equalsIgnoreCase("Tray"))
                                countCFT += foodItem[j].getQuantity();
                        }
                    }
                    countD = countDC + countDB + countDCR;
                    countP = countPC + countPB + countPBX;
                    countCF = countCFC + countCFT;
                    
                    System.out.print("\n\n[QUANTITY OF EVERY FOOD PACKAGING]\n");
                    System.out.println("\n[DRINK]\t\t: " + countD + " TOTAL");
                    System.out.println("  CAN\t\t: " + countDC);
                    System.out.println("  BOTTLE\t: " + countDB);
                    System.out.println("  CARTON\t: " + countDCR);
                    
                    System.out.println("\n[PROCESS FOOD]\t: " + countP + " TOTAL");
                    System.out.println("  CAN\t\t: " + countPC);
                    System.out.println("  BAG\t\t: " + countPB);
                    System.out.println("  BOX\t\t: " + countPBX);
                    
                    System.out.println("\n[COOKED FOOD]\t: " + countCF + " TOTAL");
                    System.out.println("  CONTAINER\t: " + countCFC);
                    System.out.println("  TRAY\t\t: " + countCFT);
                }
                
                else if(task==4)//if for expirated food
                {
                    System.out.print("\n[LIST OF FOOD THAT ALREADY EXPIRED]");
                    System.out.print("\nCURRENT DATE: 19/07/2023 13:00 P.M.");
                    for(int j = 0; j < foodItem.length; j++)
                    {
                        String listExp = foodItem[j].calExpirationDate();
                        System.out.print(listExp);
                        if(j==19)
                            break;
                    }
                    System.out.print("\n");
                }
                
                else if(task==5)
                    ans=true;
                    
                else
                {
                    continue;
                }
            }//end of while
            
            pw.close();
            br.close();
        }
        
        catch (FileNotFoundException fnfe)
        {System.out.println(fnfe.getMessage());}
        catch (IOException io)
        {System.out.println(io.getMessage());}
        catch (Exception e)
        {System.out.println(e.getMessage());}
    }
}