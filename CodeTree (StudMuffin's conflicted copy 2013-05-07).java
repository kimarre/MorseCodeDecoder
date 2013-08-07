import java.util.Scanner;

/**
* @author Kim Arre
*/

public class CodeTree extends BinaryTree {
	static BinaryTree<String> theTree = new BinaryTree<String>();
	
/**
* Creates a binary tree using the specified tree in our project spec
*/	
public static void createBinaryTree() {
		
		BinaryNode<String> treeRoot = new BinaryNode<String>("");
		theTree.insert(" ", Relative.ROOT);
		theTree.insert("E", Relative.LEFT_CHILD);
		theTree.insert("I", Relative.LEFT_CHILD);
		theTree.insert("S", Relative.LEFT_CHILD);
		theTree.insert("H", Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.insert("V", Relative.RIGHT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT); //to I
		theTree.insert("U", Relative.RIGHT_CHILD);
		theTree.insert("F", Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT); //to E
		theTree.insert("A", Relative.RIGHT_CHILD);
		theTree.insert("R", Relative.LEFT_CHILD);
		theTree.insert("L", Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT); //to A
		theTree.insert("W", Relative.RIGHT_CHILD);
		theTree.insert("P",  Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.insert("J", Relative.RIGHT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT); //to root
		theTree.insert("T", Relative.RIGHT_CHILD);
		theTree.insert("N", Relative.LEFT_CHILD);
		theTree.insert("D", Relative.LEFT_CHILD);
		theTree.insert("B", Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.insert("X", Relative.RIGHT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT); //to N
		theTree.insert("K", Relative.RIGHT_CHILD);
		theTree.insert("C", Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.insert("Y", Relative.RIGHT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT); //to T
		theTree.insert("M", Relative.RIGHT_CHILD);
		theTree.insert("G", Relative.LEFT_CHILD);
		theTree.insert("Z", Relative.LEFT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.insert("Q", Relative.RIGHT_CHILD);
		theTree.move(Relative.PARENT);
		theTree.move(Relative.PARENT);
		theTree.insert("O", Relative.RIGHT_CHILD);
		
		theTree.move(Relative.ROOT); //resets current to the root
		
	}

	/**
	* Decodes a given string in Morse code and converts to English.
	* @param morseText    The morse code string that should consist of .'s and -'s
	* @return Returns the English representation of the code
	*/
	public static String decode(String morseText) {
		
		if(morseText.length() == 0) {
			String holder = theTree.retrieve();
			theTree.move(Relative.ROOT);
			return holder;
		}
		char currentChar = morseText.charAt(0);
		
		if(currentChar != '.' && currentChar != '-' && currentChar != ' ') {
			throw new RuntimeException("Not a dot or dash.");
		}
		if(currentChar == '.') {
			theTree.move(Relative.LEFT_CHILD);
			return decode(morseText.substring(1));
		}
		else if(currentChar == '-') {
			theTree.move(Relative.RIGHT_CHILD);
			return decode(morseText.substring(1));
		}
		else if(currentChar == ' ') {
			String holder = theTree.retrieve();
			theTree.move(Relative.ROOT);
			return holder + decode(morseText.substring(1));
		}
		
		theTree.move(Relative.ROOT);
		return " ";
		
		
	}
	
	/**
	* Decodes a given string in English and converts it to Morse code.
	* @param sentence    English string to be encoded into Morse code.
	* @return Returns the Morse code representation consisting of .'s and -'s.
	*/
	public static String encode(String sentence) {
		char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' '};
		String[] morseTrans = {/*A-I*/".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
				/*J-S*/".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...",
				/*T-Z*/"-", "..-", "...-", ".--", "-..-", "-.--", "--..", ""};
		String result = "";
		sentence = sentence.toUpperCase();
		
		for(int i=0; i<sentence.length(); i++) {
			for(int j=0; j<letters.length; j++) {
				if(sentence.charAt(i) == (letters[j])) {
					result = result + morseTrans[j] + " ";
					break;
				}
			}
		}
		return result;
	}
	
	
	/**
	* Test cases made to check the quality of the program.
	*/
	public static void testCases() {
		//Decode tests:
		check("LIONS TIGERS", CodeTree.decode(".-.. .. --- -. ...  - .. --. . .-. ..."));
		check("RAWR", CodeTree.decode(".-. .- .-- .-."));
		check("THE QUICK BROWN FOX", 
				CodeTree.decode("- .... .  --.- ..- .. -.-. -.-  -... .-. --- .-- -.  ..-. --- -..-"));
		check("JUMPED OVER", CodeTree.decode(".--- ..- -- .--. . -..  --- ...- . .-."));
		check("THE LAZY DOG", CodeTree.decode("- .... .  .-.. .- --.. -.--  -.. --- --."));
		
		//Encode tests:
		check(".-. .- - ", CodeTree.encode("RAT"));
		check(".-.. .. --- -. ...  - .. --. . .-. ... ", CodeTree.encode("lions tigers"));
		check(" .-.. .. --- -. ...  - .. --. . .-. ...  ", CodeTree.encode(" li1o0ns5 tig88ers, "));
		check("- .... .  --.- ..- .. -.-. -.-  -... .-. --- .-- -.  ..-. --- -..- ", 
				CodeTree.encode("the quick BROWN fox"));
		check(".--- ..- -- .--. . -..  --- ...- . .-. ", CodeTree.encode("jumped oVER,"));
		check("- .... .  .-.. .- --.. -.--  -.. --- --. ", CodeTree.encode("the13 lazy37 dog"));
	}
	
	/**
	* Checks that two Strings are equal, and if they are not, will throw an exception.
	* @param first                The first string to be compared to the second.
	* @param second               The second string to be compared to the first.
	* @throws RuntimeException    Thrown when the two strings are not equal to each other.
	*/
	private static void check(String first, String second) {
		if(!first.equals(second)) {
			throw new RuntimeException("Not equal.");
		} 
		
	}
	
	public static void main(String[] args) {	
		boolean dontQuit = true;
		Scanner scan = new Scanner(System.in);
		char choice;
		String result, input;
		
		createBinaryTree();
		testCases();
		
		System.out.println("(p) print pre-order traversal of Binary tree");
		System.out.println("(d) decode Morse to English");
		System.out.println("(e) encode English to Morse");
		System.out.println("(q) quit");
		
		while(dontQuit) {
			System.out.print("\nChoice: ");
			choice = scan.next().charAt(0);
			
			if(choice != 'p' && choice != 'd' && choice != 'e' && choice != 'q') {
				System.out.println("Not a valid choice.");
				continue;
			}
			
			if(choice == 'q') {
				dontQuit = false;
				break;
			}
			
			if(choice == 'p') {
				System.out.println(theTree.traverse());
			}
			
			if(choice == 'd') {
				scan.nextLine();
				System.out.print("Morse to decode: ");
				input = scan.nextLine();
				result = decode(input);
				System.out.println("'" + input + "'" + " decodes to " + "'" + result + "'");
			}
			
			else {
				scan.nextLine();
				System.out.print("String to encode: ");
				input = scan.nextLine();
				result = encode(input);
				System.out.println("'" + input + "'" + " encodes to " + "'" + result + "'");
			}
		}
	}
}
