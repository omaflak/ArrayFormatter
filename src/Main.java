
public class Main{

	public static void main(String[] args) {
		String[] pronoun = {"I", "You", "He", "She", "It", "We", "You", "They"};
		String[] verb = {"am", "are", "is", "is", "is", "are", "are", "are"};
		String[] comp = {"a dog", "a unicorn", "not here", "not funny", "something", "young", "old", "nothing"};
		
		String[] formatedArray = new ArrayFormatter().getCleanArray(5, pronoun, verb, comp);
		
		/*    The first parameter is the space between each row, the others are String arrays    */
		/*                        The arrays must have the same length                           */
		 		
		 for (String str : formatedArray)
			System.out.println(str);
		 
		 /* 				OUTPUT                                          */
		 /*
		  			I        am      a dog
					You      are     a unicorn
					He       is      not here
					She      is      not funny
					It       is      something
					We       are     young
					You      are     old
					They     are     nothing
		  */
		 
		 
		 /*				EXTRA FUNCTION										*/
		 
		 int width = new ArrayFormatter().getArrayLen(5, pronoun, verb, comp); 
		 // To have the same width as the arrays above
		 String[] credit = new ArrayFormatter().getCredit("UNICORN", "#", width, 5, 6);
		 
		 /*    PARAMETERS: 
		  * 
		  * 	1) the message to display
		  *    	2) the character forming the array
		  *    	3) the width of the array
		  *     4) the height of the array
		  *     5) the space around the message
		  */
		 
		 for (String str : credit)
			 System.out.println(str);
		 
		 /* 			OUTPUT                                          */
		 
		 /*
		  			###########################
					###########################
					###       UNICORN       ###
					###########################
					###########################
		  */
		 
	}
}
