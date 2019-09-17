package chap2;
import java.util.*;

public class Chap2{
	public LinkedNode noDuplicate(LinkedNode n){
		HashSet<Integer> table = new HashSet<Integer>();
		table.add(n.getData());
		LinkedNode current = n;
		while(current.getNext() != null){
			if(table.contains(current.getNext().getData())){
				current.setNext(current.getNext().getNext());
			}else{
				table.add(current.getNext().getData());
				current = current.getNext();
			}
		}
		return n;
	}
	public LinkedNode getNthFromBehind(LinkedNode ln, int k){
		LinkedNode current = reverseLN(ln);
		for(int i=0;i<k;i++){
			current = current.getNext();
		}
		return current;
	}
	public LinkedNode reverseLN(LinkedNode ln){
		List<LinkedNode> lnList = new ArrayList<LinkedNode>();
		LinkedNode current = ln.clone();
		lnList.add(current.clone());
		while(current.getNext() != null){
			lnList.add(current.getNext().clone());
			current = current.getNext();
		}
		Collections.reverse(lnList);
		current = lnList.get(0);

		LinkedNode[] rns = lnList.toArray(new LinkedNode[lnList.size()]);
		rns = Arrays.copyOfRange(rns, 1, lnList.size());
		for(LinkedNode n: rns){
			current.setNext(n);
			current = current.getNext();
		}
		current.setNext(null);
		return lnList.get(0);
	}
	public LinkedNode removeNode(LinkedNode sln, LinkedNode targetln){
		LinkedNode f = sln;
		LinkedNode current = sln;
		while(current.getNext() != null){
			if(targetln.getData() == current.getNext().getData()){
				current.setNext(current.getNext().getNext());
				break;
			}
			current = current.getNext();
		}
		return f;
	}
	public LinkedNode splitLN(LinkedNode ln, int sepa){
		LinkedNode left = null;
		LinkedNode leftFirst = null;
		LinkedNode right = null;
		LinkedNode rightFirst = null;
		LinkedNode current = ln;
		while(current != null){
			if(sepa <= current.getData()){
				if(right == null){
					right = current.clone();
					rightFirst = right;
				}else{
					right.setNext(current.clone());
					right = right.getNext();
				}
			}else{
				if(left == null){
					left = current.clone();
					leftFirst = left;
				}else{
					left.setNext(current.clone());
					left = left.getNext();
				}
			}
			current = current.getNext();
		}
		right.setNext(null);
		if(left == null) return right;
		if(right == null) return left;
		left.setNext(rightFirst);
		return leftFirst;
	}
}
