package chap2;
import java.util.*;

public class LinkedNode{
	private LinkedNode next;
	private int data;
	public LinkedNode(){}
	public LinkedNode(int data){
		this.data = data;
	}
	public LinkedNode getNext(){
		return next;
	}
	public void setNext(LinkedNode next){
		this.next = next;
	}
	public int getData(){
		return data;
	}
	public int afterCount(){
		if(this.next == null) return 1;
		return 1 + this.next.afterCount();
	}
	public LinkedNode clone(){
		LinkedNode ln = new LinkedNode(this.data);
		ln.setNext(this.next);
		return ln;
	}
	public String toString(){
		String result = "data: " + this.data;
		if(this.next != null){
			result += "\n" + this.next.toString();
		}
		return result;
	}
}
