package ocjp_MyExamples;

enum Days
{
   
    MONDAY("day 1")
    {
        void meth(){
            System.out.println("Call monday method");
        }
    },
    
    TUESDAY("day 2")
    {
        void meth(){
            System.out.println("Call tuesday method");
        }
    },
    WEDNESDAY("day 3")
    {
        void meth(){
            System.out.println("Call wednesday method");
        }
    },
    THURSDAY("day 4")
    {
        void meth(){
            System.out.println("Call thursday method");
        }
    },
    FRIDAY("day 5")
    {
        void meth(){
            System.out.println("Call friday method");
        }
    },
    SATURDAY("day 6")
    {
        void meth(){
            System.out.println("Call saturday method");
        }
    },
    SUNDAY("day 7")
    {
        //void meth(){
        //    System.out.println("Call sunday method");
        //}
    };
    
     void meth()
     {
         System.out.println("Default implementation of method is called for Sunday");
     }
    
    private Days(String xyz)//ENUM constructor should always be private or default ( package private )
    {
        System.out.println("Constructor called for "+this); // IMPORTANT LINE HERE
    }
    
}

public class EnumExample {
    public static void main(String args[]) {
        
        Days ref=Days.MONDAY;//Constuctor is called for every enum value only once as soon as any enum value is used. In this case constructor for all enum values is invoked as enum value MONDAY is used
        
        for(Days temp:Days.values())
        {
           System.out.println(temp+"  "+temp.ordinal()); // ordinal() prints each enum values number according to its position
           temp.meth();
        }
        
        final Days fri=Days.FRIDAY;
        
        switch(ref)
        {
        
        case MONDAY:
        	System.out.println("Monday switch , position = "+ref.ordinal()); // Ordinal or position values for enums start with 0 not 1
        	break;
        	
        case TUESDAY:
        	System.out.println("Tuesday switch , position = "+ref.ordinal());
        	break;
        	
       //case Days.WEDNESDAY: This wont compile you can write only WEDNESDAY
        	
       //case 3: This wont compile enum values can't be replaced by integers
        	
       /* case fri: // Even this wont work
        * 
        *	System.out.println("Friday switch , position = "+ref.ordinal());
        *	break; */
        	
        default:
        	System.out.println("default switch");
        	
        }
        	
    }
        
        
}


