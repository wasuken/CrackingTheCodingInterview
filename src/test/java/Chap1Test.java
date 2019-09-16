package chap1;
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
	@Test
	public void orderCheckTest(){
		Chap1 c = new Chap1();
		String a_1 = "test";
		String b_1 = "ttes";
		assertThat(c.orderCheck(a_1, b_1), is(true));

		String a_2 = "kalsjdfadsjfjs";
		String b_2 = "lsakdjfdsakfda";
		assertThat(c.orderCheck(a_2, b_2), is(false));
	}
	@Test
	public void replaceSpaceTest(){
		Chap1 c = new Chap1();
		String a_1 = "test";
		String b_1 = "test";
		assertThat(c.replaceSpace(a_1), is(b_1));

		String a_2 = "te st";
		String b_2 = "te%20st";
		assertThat(c.replaceSpace(a_2), is(b_2));
	}
	@Test
	public void isPalindromeTest(){
		Chap1 c = new Chap1();
		String s1 = "teet";
		String s2 = "lkdsfakjl";
		String s3 = "abcba";
		assertThat(c.isPalindrome(s1), is(true));
		assertThat(c.isPalindrome(s2), is(false));
		assertThat(c.isPalindrome(s3), is(true));
	}
	@Test
	public void isOneShotEqualTest(){
		Chap1 c = new Chap1();
		String a_1 = "pale";
		String b_1 = "ple";
		assertThat(c.isOneShotEqual(a_1, b_1), is(true));

		String a_2 = "pales";
		String b_2 = "pale";
		assertThat(c.isOneShotEqual(a_2, b_2), is(true));

		String a_3 = "bale";
		String b_3 = "pale";
		assertThat(c.isOneShotEqual(a_3, b_3), is(true));

		String a_4 = "pale";
		String b_4 = "bake";
		assertThat(c.isOneShotEqual(a_4, b_4), is(false));
	}
	@Test
	public void stringCompressionTest(){
		Chap1 c = new Chap1();
		String s1 = "aabcccccaaa";
		String s1Expected = "a2b1c5a3";
		assertThat(c.stringCompression(s1), is(s1Expected));

		String s2 = "";
		String s2Expected = "";
		assertThat(c.stringCompression(s2), is(s2Expected));

		String s3 = "a";
		String s3Expected = "a1";
		assertThat(c.stringCompression(s3), is(s3Expected));
	}
	@Test
	public void spinMatrixTest(){
		Chap1 c = new Chap1();
		int[][] matrix1 = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		int[][] matrixExpected1 = {{7,4,1}, {8,5,2},{9,6,3}};
		assertThat(c.spinMatrix(matrix1), is(matrixExpected1));

		int[][] matrix2 = {{1,1,1,1},
						   {2,2,2,2},
						   {3,3,3,3},
						   {4,4,4,4}};
		int[][] matrixExpected2 = {{4,3,2,1},
								   {4,3,2,1},
								   {4,3,2,1},
								   {4,3,2,1}};

		assertThat(c.spinMatrix(matrix2), is(matrixExpected2));
	}
	@Test
	public void isZeroColAndRowFillZero(){
		Chap1 c = new Chap1();

	}
}
