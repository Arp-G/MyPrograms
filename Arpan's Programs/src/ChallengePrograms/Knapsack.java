package ChallengePrograms;
import java.util.Scanner;

class Sack 
{
   
    private String item;
    private double profit;
    private double weight;

    public void get_data(String a,double b,double c)
    {
        item=a;
        profit=b;
        weight=c;
    }
    
    public static void Sort(Sack obj[])
    {
        int length=obj.length;
        for(int i=0;i<length-1;i++)
        {
            
            for(int j=0;j<length-i-1;j++)
            {
              if(obj[j].profit<obj[j+1].profit)
              {
                  Swap(obj[j],obj[j+1]);
              }
            }
        }
    }
    
    public static void Swap(Sack obj1,Sack obj2)
    {
        Sack temp=new Sack();
        
        temp.item=obj1.item;
        temp.profit=obj1.profit;
        temp.weight=obj1.weight;
        
        obj1.item=obj2.item;
        obj1.profit=obj2.profit;
        obj1.weight=obj2.weight;
        
        obj2.item=temp.item;
        obj2.profit=temp.profit;
        obj2.weight=temp.weight;
    }
    
    public static void Strategy1(Sack obj[],double capacity)
    {
        int i=0;
        double temp,totalProfit=0.0;
        
       System.out.println("Item Choosen  Quantity   Space Remaing    P*x");
       System.out.println("              of  Item    in the Sack        ");
       System.out.println("---------------------------------------------");
        while(i<obj.length)
        {
            if(capacity-obj[i].weight>0)
            {
                System.out.println(obj[i].item + "      1 Full item   " + capacity +  "-"  +  obj[i].weight + "=" + (capacity-obj[i].weight) +"    "+ obj[i].profit + "* 1" + "=" + obj[i].profit);
                capacity=capacity-obj[i].weight;
                totalProfit=totalProfit+obj[i].profit;
                
            }
            else if(capacity==0)
            {
               break;    
            }
            else
            {
                temp=capacity/obj[i].weight;
                System.out.println(obj[i].item + "         " + temp + " item    " + capacity +  "-"  +  capacity + "= 0   " + obj[i].profit + "* " + temp + "=" + capacity);
                capacity=0;
                temp=obj[i].profit*temp;
                totalProfit=totalProfit+temp;
            }
            System.out.println();
            
            i++;
            
        }
        System.out.println("Total Profit = "+totalProfit);
    }
}
    
    

            

class Knapsack
{
    
    public static void main(String[] args) 
    {
        String Item;
        double profit,weight,capacity;
        int size;
        Scanner sc = new Scanner(System. in);
        System.out.println("Enter the capacity of the Sack");
        capacity=sc.nextInt();
        System.out.println("Enter the number of items present");
        size=sc.nextInt();
        
        Sack obj[]=new Sack[size];
   
        for(int i=0;i<size;i++)
        {
            obj[i]=new Sack();//Constructor call for each object
            System.out.println("Enter Details for Item "+(i+1)+" : ");
            System.out.println("-----------------------------");
            System.out.print("Enter Item Name for item "+(i+1)+" : ");
            Item=sc.next();
            System.out.print("Enter Item Profit for item "+(i+1)+" : ");
            profit=sc.nextInt();
            System.out.print("Enter Item Weight for item "+(i+1)+" : ");
            weight=sc.nextInt();
            
                obj[i].get_data(Item, profit, weight);
                
            
        }
       
     Sack.Sort(obj);
     Sack.Strategy1(obj,capacity);
      
    }
    
}
