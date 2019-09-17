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
	public LinkedNode createLinkedList(int... datas){
		LinkedNode n = new LinkedNode(datas[0]);
		LinkedNode f = n;
		for(int i:Arrays.copyOfRange(datas, 1, datas.length)){
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
