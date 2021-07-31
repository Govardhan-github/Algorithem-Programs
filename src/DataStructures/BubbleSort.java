package DataStructures;
/*
 * Program To Sort The Integers In Ascending Order By Using Bubble Sort
 */
public class BubbleSort {
	/*
	 * Declaring Main Method Here
	 */
public static void main(String[] args) {
	// Read The Integer List From The User
	Integer[] intArray = getIntegerList();
	// Before Sorting
	Utility.display(intArray, "Before Sorting");
	// Sort Using Insertion Algorithm
	applyBubbleSort(intArray);
	// After Sorting
	Utility.display(intArray, "After Sorting");
}
/*
 * Method To Apply The Bubble Sort
 */
private static void applyBubbleSort(Integer[] intArray) {
	int n = intArray.length;
	for (int i = 0; i < n - 1; i++) 
	for (int j = 0; j < n - i - 1; j++)
	if (intArray[j] > intArray[j + 1]) {
	int temp = intArray[j];
	intArray[j] = intArray[j + 1];
	intArray[j + 1] = temp;
	}
}
//Method To Take The Position Values For Bubble Sorting
private static Integer[] getIntegerList() {
	System.out.println("Enter the Size of the int array.");
	int size = Utility.getInteger();
	Integer[] intArray = new Integer[size];//Declaring Array
	//For Loop To Enter The Values Into Array
	for (int pos = 0; pos < intArray.length; pos++) {
	System.out.println("Enter the int value for position " + pos);
	intArray[pos] = Utility.getInteger();//Taking The Position
	}
return intArray;//Return intArray
	}
}
