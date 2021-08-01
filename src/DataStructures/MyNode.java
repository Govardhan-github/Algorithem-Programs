package DataStructures;

public class MyNode<K > implements INode<K> {
		
		private K key ;
		private INode<K> next;
		 public MyNode(K key) {
			 this.key = key;
			 this.next = null;
		 }
		 public void setKey(K key) {
			 this.key = key;
			 
		 }
		 public K getkey() {
			 return  this.key;
		 }
		 public void setNext(INode next) {
			 this.next = next;
		 }
		 public INode getNext() {
			 return this.next;
		 }
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return null;
		}
	}
