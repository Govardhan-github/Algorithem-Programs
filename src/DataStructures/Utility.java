package DataStructures;
//Importing The Java Package
import java.util.Scanner;
/*
 * Declaring The Utility Class For Binary Search Word
 */
public class Utility {
	//Read The Word To Be Searched From The User
	static Scanner scanner = new Scanner(System.in);
	public static String getWord() {
	return scanner.next();
	}
	public static int getInteger() {
	return scanner.nextInt();
	}
	/*
	 * Declaring Method To Display The Words
	 */
public static  <T> void display(T [] words, String message) {
	StringBuilder builder = new StringBuilder("Array "+message+": [");
	for (int pos = 0; pos < words.length; pos++) {
	builder.append(words[pos]).append(" ");
	}
	builder.append("]");
	System.out.println(builder.toString());
	}
}