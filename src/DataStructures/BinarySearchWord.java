package DataStructures;
//Importing The Packages From Java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWord {
	/*
	 * Declaring Main Method 
	 */
public static void main(String[] args) throws IOException {
	//Get The Words List From The File
	String[] words = getWordsListFromFile(args[0]);
	//Sort The List Using Arrays Sort Method
	Arrays.sort(words);
	//Display After Sorting
	Utility.display(words, "After Sorting");
	//Read The Word To Be Searched From The User
	Scanner scanner = new Scanner(System.in);
	System.out.println("Enter the word to be searched...");
	String word = scanner.next();
	//Apply Binary Search
	int index = binarySearch(words, word);
	//Check Word Found Or Not
	if(index >= 0) {
		System.out.println("Word found at position  " + index);
	}else {
		System.out.println("Word not found.");
	}
	scanner.close();
}
/*
 * Declaring Method To Find Binary Search Index
 */
private static int binarySearch(String[] words, String word) {
	int l = 0, r = words.length - 1;//Declaring variables
	//While Condition To Find Index
	while (l <= r) {
		int m = l + (r - l) / 2;//Finding Mid 
	    int res = word.compareTo(words[m]);//Comparing The Word And Mid
	    // Check If x Is Present At Mid
	    if (res == 0)
        return m;
	    // If x Greater, Ignore left Half
	    if (res > 0)
	    l = m + 1;
	    // If x Is Smaller, Ignore Right Half
	    else
        r = m - 1;
	    }
		return -1;
	}
/*
 * Method To Get WordsList From The File
 */
private static String[] getWordsListFromFile(String filePath) throws IOException {
	String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
	return content.split(",");//Returning Content.split
		}
}