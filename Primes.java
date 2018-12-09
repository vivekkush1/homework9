import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {
    	ListInterface<Integer> candidates = null;
    	ListInterface<Integer> primes = new AList<Integer>();
    	ListInterface<Integer> composites = new AList<Integer>();
        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        // COMPLETE THE MAIN
        candidates=new AList<Integer>(max);
        for(int i=0;i<max-1;i++)
        {
        	candidates.add(i+2);
        }
        
        System.out.println("The candidates list is " + candidates);
        int i=1,count=1;
        while(!candidates.isEmpty())
        {
        	System.out.println("\nAfter "+count+ " round :");
        	primes.add(candidates.getEntry(i));
        	int prime=candidates.getEntry(i);
        	 candidates.remove(i);
        	 getComposites(candidates, composites,prime );
        	 System.out.println("candidates list :"+candidates);
        	 System.out.println("primes list :" + primes);
        	 System.out.println("composite list :"+composites);
        	 count++;
        }
    }
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
       int length=candidates.getLength();
       
       for(int i=1;i<=length;i++)
       {
    	   if(candidates.getEntry(i) % prime==0)
    	   {
    		   composites.add(candidates.getEntry(i));
    		   candidates.remove(i);
    		   i--;
    	   }
    	   length=candidates.getLength();
       }
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}