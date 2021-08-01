package DataStructures;
/*
 *Program To Sort The Elements In Ascending Order By Using Merge Sort
 *First We Have To Divide The Array Into Two Parts With MidPoint
 *After That We Have To Do Sorting For Left Side And Right Side
 *And Combining The Both Left And Right Sort
 *Do Merge Sort For Combining Sort
 */
public class MergeSort {
/*
 *Method To Print Array Elements 
 */
public static void PrintArray(int[] array) {
	for(int i : array) {
		System.out.println(i+" ");
		}
		System.out.println();
	}
/*
 * Declaring Merge Sort Method
 * To Sort Elements In Ascending Order
 */
private static int[] mergeSort(int[] array) {
	if(array.length<=1) {
	return array;
	}
	int midPoint = array.length / 2;//Array Divide Into MidPoint
	int[] left = new int[midPoint];
	int[] right = new int[midPoint];
	//IfCondition To Sort The Elements Right Side
	if(array.length %2 == 0) {
		right = new int[midPoint];
	}
	else {
		right = new int[midPoint + 1];
	}
	//For Loop To Traverse The Elements To Sort In Left Side
	for(int i =0; i<midPoint;i++) {
		left[i] = array[i];
	}//For Loop To Traverse The Elements To Sort In Right Side
	for(int j=0;j<right.length;j++) {
		right[j] = array[midPoint+j];
	}
	int[] result = new int[array.length];
	left =mergeSort(left);//Merging LeftSide Part
	right =mergeSort(right);//Merging RightSide Part
	result = merge(left,right);//Both Left And Right Parts Merging In Result
	return result;//Return Result
}

/*
 * Declaring Merge Method 
 * To Sorting Left And Right Parts
 */
private static int[] merge(int[] left, int[] right) {
	int[] result = new int[left.length + right.length];//
	int leftPointer,rightPointer,resultPointer;//Declaring The Variables
	leftPointer = rightPointer =resultPointer = 0;
	//While Loop To Traverse The Elements To Sort In Merge Sort
	while(leftPointer < left.length || rightPointer < right.length) {
		if(leftPointer < left.length && rightPointer < right.length) {
				if(left[leftPointer] < right[rightPointer]) {//	If Condition Satisfy The Pointer Points To Left Side
				result[resultPointer++] = left[leftPointer++];
				}
				else {//The Pointer Points To Right Side
				result[resultPointer++] = right[rightPointer++];
				}
		}//End Of If Condition 1
		else if(leftPointer < left.length) {
		result[resultPointer++] = left[leftPointer++];//The Pointer Points To LeftSide 
		}
		else if(rightPointer < right.length) {
		result[resultPointer++] = right[rightPointer++];//The Pointer Points To Right Side
		}
	}//End Of While Loop
	return result;//Return The Result
}
/*
 * Declaring Main Method Here
 * To Sort The Elements In Ascending Order
 */
public static void main(String[] args) {
	int[] array = {89,75,523,758};//Giving Integer Values To Sort
	System.out.println("Intial Array : ");//Printing Initial Array
	PrintArray(array);
	array = mergeSort(array);//Calling MergeSort Method And Sort The Elements
	System.out.println("Sorted Array : ");//Printing Sorted Array
	PrintArray(array);	
	}
}