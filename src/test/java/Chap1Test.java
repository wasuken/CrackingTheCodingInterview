package Chap1;
import java.util.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Chap1Test{
	@Test
	public void noDuplicateTest(){
		Chap1 c = new Chap1();
		String s1 = "test";		// NG
		String s2 = "abc";		// OK
		String s3 = "";			// OK

		assertThat(c.noDuplicate(s1), is(false));
		assertThat(c.noDuplicate(s2), is(true));
		assertThat(c.noDuplicate(s3), is(true));
	}
}
