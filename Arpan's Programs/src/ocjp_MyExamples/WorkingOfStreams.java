package ocjp_MyExamples;


import java.util.function.*;
import java.util.stream.*;
import java.util.Optional;

public class WorkingOfStreams 
{
	
    public static void main(String args[]) 
    {
        Stream<Integer> inf=Stream.iterate(1,x->x+1);
        
        inf.filter((x)->{
                            if(x<=10)
                            {
                              System.out.println("Filtered : "+x);
                              return true;
                            }
                            return false;
                            
                        }).map((x)->{
                                        System.out.println("Mapped "+x+" to "+(x*2));
                                        return x*2;
                                    }).forEach(x->System.out.println("print "+x));
                        
                             
    }
    
   
}
