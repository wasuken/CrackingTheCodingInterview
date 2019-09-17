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
	public LinkedNode lnAdd(LinkedNode a, LinkedNode b){
		int result = lnToInt(reverseLN(a)) + lnToInt(reverseLN(b));
		return reverseLN(intToLn(result));
	}
	public LinkedNode lnStraightAdd(LinkedNode a, LinkedNode b){
		int result = lnToInt(a) + lnToInt(b);
		return intToLn(result);
	}
	public int lnToInt(LinkedNode ln){
		LinkedNode current = ln;
		int result = 0;
		while(current != null){
			result = result * 10 + current.getData();
			current = current.getNext();
		}
		return result;
	}
	public LinkedNode intToLn(int n){
		int i = n;
		LinkedNode ln = null;
		LinkedNode lnFirst = null;
		while(n >= 0){
			if(n >= 10){
				int one = n % 10;
				if(ln == null){
					ln = new LinkedNode(one);
					if(lnFirst == null) lnFirst = ln;
				}else{
					ln.setNext(new LinkedNode(one));
					ln = ln.getNext();
				}
				n = (n - one) / 10;
			}else{
				if(ln == null){
					ln = new LinkedNode(n);
					if(lnFirst == null) lnFirst = ln;
				}else{
					ln.setNext(new LinkedNode(n));
				}
				n = -1;
			}
		}
		return reverseLN(lnFirst);
	}
	public boolean isLnPalidrome(LinkedNode ln){
		return ln.equalsLNDatas(reverseLN(ln));
	}
	public LinkedNode commonNode(LinkedNode a, LinkedNode b){
		HashSet<LinkedNode> table = new HashSet<LinkedNode>();
		LinkedNode current = a;
		while(current != null){
			table.add(current);
			current = current.getNext();
		}
		current = b;
		while(current != null){
			if(table.contains(current)){
				return current;
			}
			current = current.getNext();
		}
		return null;
	}
	public boolean isLoop(LinkedNode ln){
		HashSet<LinkedNode> table = new HashSet<LinkedNode>();
		LinkedNode current = ln;
		while(ln.getNext() != null){
			if(table.contains(ln)){
				return true;
			}else{
				table.add(ln);
			}
			ln = ln.getNext();
		}
		return false;
	}
}
