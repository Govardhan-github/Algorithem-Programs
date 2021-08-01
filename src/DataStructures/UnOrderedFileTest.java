package DataStructures;
//Importing Java Packages
import java.io.FileWriter;

import java.io.IOException;

import java.nio.charset.StandardCharsets;

import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.Scanner;

public class UnOrderedFileTest {
	/*
	 * Declaring Main Method
	 */
public static void main(String[] args) throws IOException {
	//Read The File Into Words Array
	String[] wordArray = readFile(args[0]);
	//Adding The Words Into Unordered List
	UnOrderedList<String> list = new UnOrderedList<String>();
	for (String word : wordArray) {
	list.append(word);
	}
	//Print The Nodes
	list.printNodes();
	//Take The User Input To Search The Word
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a word from list to search");
	String searchWord = sc.nextLine();
	boolean flag = list.search(searchWord);
	//If Not Found We Will Add The Word To The List, If Found We Will Remove The Word
	if (!flag) {
	list.append(searchWord);
	} else {
	list.remove(searchWord);
	list.printNodes();
	}
	//Getting String Content From The List
	String updatedContent = getStringContentFromList(list);
	//Writing To The File
	writeFile(updatedContent, args[1]);
	}
/*
 * Declaring The Method To WriteFiles
 */
private static void writeFile(String content, String filePath) throws IOException {
	FileWriter fw = new FileWriter(filePath);//Declaring Fw 
	fw.write(content);//Printing Fw Content
	System.out.println("Writing successful");
	fw.close();
	}
//Method To Read The File In Path
private static String[] readFile(String filepath) throws IOException {
	String content = new String(Files.readAllBytes(Paths.get(filepath)), StandardCharsets.UTF_8);
	return content.split(" ");
	}
//Method To Store The Update Content
private static String getStringContentFromList(UnOrderedList<String> list) {
	String updatedContent = "";
	for (int i = 0; i < list.size(); i++) {
	updatedContent = updatedContent.concat(list.get(i)).concat(" ");
		}
	return updatedContent;
	}
}