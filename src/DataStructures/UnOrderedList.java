package DataStructures;
//Declaring UnOerderd List With Extends Of Comparable
public class UnOrderedList<T extends Comparable<T>> {
public INode<T> head;//Declaring head Variable
public INode<T> tail;//Declaring tail Variable
private int size;//Declaring Size
// Default Constructor
public UnOrderedList() {
}
//Method To Add The Values 
public void add(T value) {
INode<T> node = new MyNode<>(value);//Value Stored In Node
if (this.head == null) {//If Head Is Null
this.head = node;//Node Is Points To Head
}
if (this.tail == null) {//If Tail Is Null
this.tail = node;//Node Is Points To Tail
} else {
INode<T> temp = head;//Head Value IsmStored In Temp
this.head = node;//Node Is Stored In Head
this.head.setNext(temp);//Head.setNext To Temp 
}
size++;//Increment Of Size
}
//Method To Append The Values Into File
public void append(T value) {
INode<T> newNode = new MyNode<>(value);//Value Stored In newNode
if (this.head == null) {//If Head Is Null
this.head = newNode;//newNode Stored In Head
}
if (this.tail == null) {//If Tail Is Null
this.tail = newNode;//NewNode Store In Tail
} else {
this.tail.setNext(newNode);//Tail.setNext To newNode
this.tail = newNode;//NewNode stores In TAil
}
size++;//Increment Of Size
}
//Method To Remove The Key From File
public boolean remove(T value) {
INode<T> currNode = head;//Head Assign To CurrNode
INode<T> previousNode = head;//Head Assign To PreviousNode
if (head.getKey().compareTo(value) == 0) {
head = head.getNext();//Head Points To Head.GetNext
size--;//Decrement Of Size
return true;//Return True
}
if (null != currNode) {
while ((null != currNode.getNext()) || (null != currNode.getKey())) {
//match condition
if (currNode.getKey().compareTo(value) == 0) {
previousNode.setNext(currNode.getNext());
//In Case of Last Element
if (currNode == this.tail) {
this.tail = previousNode;
}
size--;
return true;
}
previousNode = currNode;//CurrentNode Stored In PrevNode
currNode = currNode.getNext();//CurrNode GetNext Points To CurrNode 
if (null == currNode) {//If Null Equals CurrentNode 
return false;//Return False
			}

		}
	}
return false;
}

//Method To Search Node In File
public boolean search(T value) {
int index = index(value);//Index Value Stored In Index
//If Condition To Check The Index Of The Node
if (index >= 0) {
return true;
}
return false;
}
//Method To Print The File Is Empty
public boolean isEmpty() {
return this.size == 0;
}
//Method To Print The Size
public int size() {
return this.size;
}//Method To Know The Index Value Of Node
public  int index(T value) {
INode<T> currNode = (INode<T>) head;//Head Is Stored In CurrNode
int index = 0;
if (null != currNode) {//If Null Not Equals CurrNode
//Traversing The Nodes
while ((null != currNode.getNext()) || (null != currNode.getKey())) {
//Match The Condition
if (currNode.getKey().compareTo(value) == 0) {
break;
}
currNode = currNode.getNext();
if (null == currNode) {
return -1;
}
index++;//Increment Of Index
}
}
return index;
}
//Method To Pop Operation
//To Delete The Nodes
public T pop() {
INode<T> temp = this.head;//This.Head Points To Temp
//While Cindition To Traverse The Nodes
while (temp.getNext() != this.tail) {
temp = temp.getNext();
}
this.tail = temp;//Temp Stores In Tail
temp = temp.getNext();//tenp Points To Temp.getnext 
tail.setNext(null);
size--;//Decrement Of Size
return temp.getKey();
}
//Method To Pop
public T pop(int index) {
if (head == null) {
return null;
}
if (index == 0) {
T key = head.getKey();
head = head.getNext();
size--;
return key;
}
int i = 0;
INode<T> currentNode = this.head;
INode<T> previousNode = currentNode;
while ((null != currentNode.getNext()) || (null != currentNode.getKey())) {
//match the index
if (i == index) {
previousNode.setNext(currentNode.getNext());
size--;
return (T) currentNode.getKey();
}
previousNode = currentNode;
currentNode = currentNode.getNext();
i++;
}
return null;
}
//Method To Insert The value In File
public void insert(int index, T value) {
INode<T> newNode = new MyNode<>(value);//value Stored In NewNode
if (index == 0) {//If Index Is Zero
newNode.setNext(head);//NewNode.setNext Points To Head
head = newNode;//NewNode Stored In Head
size++;//Increment Of Size
return;
} else {
INode<T> nodeAtPreviousIndex = head;
for (int i = 0; i < index - 1; i++) {
nodeAtPreviousIndex = nodeAtPreviousIndex.getNext();
//If the element we are trying insert at the tail position
if(i == (index - 2)) {
nodeAtPreviousIndex.setNext(newNode);
tail = newNode;
size++;
return;
}
}
newNode.setNext(nodeAtPreviousIndex.getNext());
nodeAtPreviousIndex.setNext(newNode);
size++;
}
}
//Method To Print The Nodes
public void printNodes() {
StringBuilder nodes = new StringBuilder("Node Keys : ");
INode<T> temp = this.head;
while (temp != null) {
nodes.append(temp.getKey());
if (temp != tail) {
nodes.append("->");
}
temp = temp.getNext();
}
System.out.println(nodes);
}
//Method To Get Index Of Values
public T get(int index) {
if (head == null) {
return null;
}
INode<T> currNode = head;
int i = 0;
if (null != currNode) {
while ((null != currNode.getNext()) || (null != currNode.getKey())) {
if (i == index) {
return currNode.getKey();
}
currNode = currNode.getNext();
i++;
}
}
return null;
}
}