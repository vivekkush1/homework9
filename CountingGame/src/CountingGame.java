import java.io.*;
import java.util.*;

/**
 * CountingGame is a program that will simulate a children's counting game used to select
 * someone.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
    
public class CountingGame
{

    public static void main(String args[])
    {
        ListInterface<Integer> players = null;
        ListInterface<String> rhyme = null;
        
        int max;
        int position = 1;       // always start with the first player
        
        System.out.println("Please enter the number of players.");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        System.out.println("Constructing list of players");
        
        // ADD CODE HERE TO CREATE THE LIST OF PLAYERS
        players=new AList<Integer>(max);
        for(int i=0;i<max;i++)
        {
        	players.add(i+1);
        }
        
        System.out.println("The players list is " + players);
        
        rhyme = getRhyme();
        int ans=1;
        for(int i=0;i<max-1;i++)
        {
        	ans=doRhyme(players, rhyme,ans);
        }
        
        System.out.println("The winner is " + players.getEntry(1));
    }
    
    
    /**
     * Do the rhyme with the players in the list and remove the selected
     * player.
     *
     * @param  players   A list holding the players.
     * @param  rhyme   A list holding the words of the rhyme.
     * @param  startAt A position to start the rhyme at.
     * 
     * @return The position of the player eliminated.
     */
    
   // For each word in the rhyme  
    //Print the word in the rhyme and the player that says it. 
   // Print the name of the player to be removed. Remove that player from the list. 
   // Return the index of the player that will start the next round. 
    
    
   public static int doRhyme(ListInterface<Integer> players, ListInterface<String> rhyme, int startAt)
    {
	   int i=players.getLength();
	   int j=startAt-1;
	   for(int k=1;k<=rhyme.getLength();k++)
	   {
        	System.out.println("Player "+players.getEntry((j % i)+1)+": "+rhyme.getEntry(k));
        	j++;
        }
	   j--;
	   System.out.println("Removing Player : "+players.getEntry((j % i)+1));
	   players.remove((j % i)+1);
	   
	   System.out.println("The players list is " + players);
	   
    	   return (j % i)+1;  
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
    
    /**
     * getRhyme - Get the rhyme.
     *
     * @return    A list of words that is the rhyme.
     */
    private static ListInterface<String> getRhyme()
    {
        Scanner input;
        String inString = "";
        ListInterface<String> rhyme = new AList<String>();
        
        try
        {
            input = new Scanner( System.in );
            
            System.out.println("Please enter a rhyme");
            inString = input.nextLine().trim();
            
            Scanner rhymeWords = new Scanner(inString);
            while(rhymeWords.hasNext())
            {
                rhyme.add(rhymeWords.next());
            }
            
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use a rhyme of size one");
        }

        // Make sure there is at least one word in the rhyme
        if(rhyme.getLength() < 1)
            rhyme.add("Default");
            
        return (ListInterface<String>)rhyme;
                                    
    }
    
}
