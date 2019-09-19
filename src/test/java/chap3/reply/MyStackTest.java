package reply;
import java.util.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class MyStackTest{
	@Test
	public void afterSizeTest(){
		MyStack<Integer> s1 = new MyStack<Integer>(0);
		assertThat(s1.afterSize(), is(100));
		s1.pop();
		assertThat(s1.afterSize(), is(99));
	}
	@Test
	public void popTest(){
		MyStack<Integer> s1 = new MyStack<Integer>(0);
		assertTrue(s1.pop() == null);
		for(int i=1;i<100;i++){
			s1.push(i);
		}
		assertThat(s1.pop().getValue(), is(99));
		assertThat(s1.pop().getValue(), is(98));
	}
}
