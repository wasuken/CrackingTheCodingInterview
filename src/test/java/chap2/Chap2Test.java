package chap2;
import java.util.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Chap2Test{
	// 2-1
	// 重複要素の削除:ソートされていない連結リストから、重複する要素を削除する。
	@Test
	public void noDuplicateTest(){
		Chap2 c = new Chap2();
		LinkedNode result = c.noDuplicate(createLinkedList(10,10,10,10,10));
		assertThat(result.afterCount(), is(1));
		result = c.noDuplicate(createLinkedList(10,20,30,40,50));
		assertThat(result.afterCount(), is(5));
		result = c.noDuplicate(createLinkedList(10,20,30,20,10));
		assertThat(result.afterCount(), is(3));
		result = c.noDuplicate(new LinkedNode(10));
		assertThat(result.afterCount(), is(1));
	}
	@Test
	public void getNthFromBehindTest(){
		Chap2 c = new Chap2();
		LinkedNode result = createLinkedList(10,20,30,40,50);
		assertThat(c.getNthFromBehind(result, 0).getData(), is(50));
		assertThat(c.getNthFromBehind(result, 1).getData(), is(40));
		assertThat(c.getNthFromBehind(result, 2).getData(), is(30));
		assertThat(c.getNthFromBehind(result, 3).getData(), is(20));
		assertThat(c.getNthFromBehind(result, 4).getData(), is(10));
	}
	@Test
	public void reverseLNTest(){
		Chap2 c = new Chap2();
		LinkedNode resultA = createLinkedList(10,20,30,40,50);
		LinkedNode resultB = createLinkedList(10,20,30,40,50);
		assertTrue(equalsLNDatas(resultA, resultB));
		resultA = createLinkedList(10,20,30,40,50);
		resultB = createLinkedList(50,40,30,20,10);
		assertTrue(equalsLNDatas(resultA, c.reverseLN(resultB)));
	}
	@Test
	public void removeNodeTest(){
		Chap2 c = new Chap2();
		LinkedNode resultA = createLinkedList(10,20,30,40,50);
		LinkedNode resultB = createLinkedList(10,30,40,50);
		assertTrue(equalsLNDatas(c.removeNode(resultA, new LinkedNode(20)), resultB));
		resultA = createLinkedList(10,20,30,40,50);
		resultB = createLinkedList(10,20,40,50);
		assertTrue(equalsLNDatas(c.removeNode(resultA, new LinkedNode(30)), resultB));
		resultA = createLinkedList(10,20,30,40,50);
		resultB = createLinkedList(10,20,30,50);
		assertTrue(equalsLNDatas(c.removeNode(resultA, new LinkedNode(40)), resultB));
		resultA = createLinkedList(10,20,30,40,50);
		resultB = createLinkedList(10,20,30,40);
		assertTrue(equalsLNDatas(c.removeNode(resultA, new LinkedNode(50)), resultB));
		resultA = createLinkedList(10,20,30,40,50);
		resultB = createLinkedList(10,20,30,40,50);
		assertTrue(equalsLNDatas(c.removeNode(resultA, new LinkedNode(60)), resultB));
	}
	@Test
	public void splitLNTest(){
		Chap2 c = new Chap2();
		LinkedNode resultA = createLinkedList(3,5,8,5,10,2,1);
		LinkedNode resultB = createLinkedList(3,2,1,5,8,5,10);
		assertTrue(equalsLNDatas(c.splitLN(resultA, 5), resultB));
		resultA = createLinkedList(10,20,30,40,50);
		resultB = createLinkedList(10,20,30,40,50);
		assertTrue(equalsLNDatas(c.splitLN(resultA, 30), resultB));
	}
	@Test
	public void lnAddTest(){
		Chap2 c = new Chap2();
		LinkedNode resultA = createLinkedList(7,1,6);
		LinkedNode resultB = createLinkedList(5,9,2);
		LinkedNode resultC = createLinkedList(2,1,9);
		assertTrue(equalsLNDatas(c.lnAdd(resultA, resultB), resultC));
	}
	@Test
	public void lnStraightAddTest(){
		Chap2 c = new Chap2();
		LinkedNode resultA = createLinkedList(6,1,7);
		LinkedNode resultB = createLinkedList(2,9,5);
		LinkedNode resultC = createLinkedList(9,1,2);
		assertTrue(equalsLNDatas(c.lnStraightAdd(resultA, resultB), resultC));
	}
	@Test
	public void intToLnTest(){
		Chap2 c = new Chap2();
		int i = 716;
		assertTrue(equalsLNDatas(c.intToLn(i), createLinkedList(7,1,6)));
	}
	@Test
	public void lnToIntTest(){
		Chap2 c = new Chap2();
		LinkedNode resultA = createLinkedList(7,1,6);
		assertThat(c.lnToInt(resultA), is(716));
		resultA = createLinkedList(7);
		assertThat(c.lnToInt(resultA), is(7));
	}
	@Test
	public void isLnPalindromeTest(){
		Chap2 c = new Chap2();
		assertTrue(c.isLnPalidrome(createLinkedList(7,1,7)));
	}
	@Test
	public void commonNodeTest(){
		Chap2 c = new Chap2();
		LinkedNode ln1 = createLinkedList(1,2,3,4,5);
		LinkedNode ln2 = createLinkedList(6,7,8);
		ln1.setNext(ln2);
		assertTrue(equalsLNDatas(c.commonNode(ln1, ln2), ln2));
		ln1 = createLinkedList(1,2,3,4,5);
		ln2 = createLinkedList(6,7,8);
		LinkedNode ln3 = createLinkedList(1,2,3);
		ln1.setNext(ln2);
		assertTrue((c.commonNode(ln1, ln3) == null));
	}
	@Test
	public void isLoopTest(){
		Chap2 c = new Chap2();
		LinkedNode ln1 = createLinkedList(1,2,3,4,5);
		ln1.lastNode().setNext(ln1);
		assertTrue(c.isLoop(ln1));
		ln1 = createLinkedList(1,2,3,4,5);
		LinkedNode ln2 = createLinkedList(1,2,3,4,5);
		ln1.lastNode().setNext(ln2);
		assertFalse(c.isLoop(ln1));
	}
	public LinkedNode createLinkedList(int... nums){
		LinkedNode n = new LinkedNode(nums[0]);
		LinkedNode f = n;
		for(int i:Arrays.copyOfRange(nums, 1, nums.length)){
			n.setNext(new LinkedNode(i));
			n = n.getNext();
		}
		n.setNext(null);
		return f;
	}
	public boolean equalsLNDatas(LinkedNode a, LinkedNode b){
		while(a != null && b != null){
			if(a.getData() != b.getData()) return false;
			a = a.getNext();
			b = b.getNext();
		}
		return !((a == null) && (b != null) || (a != null) && (b == null));
	}
}
