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
		String s1Was = "a2b1c5a3";
		assertThat(c.stringCompression(s1), is(s1Was));

		String s2 = "";
		String s2Was = "";
		assertThat(c.stringCompression(s2), is(s2Was));

		String s3 = "a";
		String s3Was = "a1";
		assertThat(c.stringCompression(s3), is(s3Was));
	}
	@Test
	public void spinMatrixTest(){
		Chap1 c = new Chap1();
		int[][] matrix1 = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		int[][] matrixWas1 = {{7,4,1}, {8,5,2},{9,6,3}};
		assertThat(c.spinMatrix(matrix1), is(matrixWas1));

		int[][] matrix2 = {{1,1,1,1},
						   {2,2,2,2},
						   {3,3,3,3},
						   {4,4,4,4}};
		int[][] matrixWas2 = {{4,3,2,1},
								   {4,3,2,1},
								   {4,3,2,1},
								   {4,3,2,1}};

		assertThat(c.spinMatrix(matrix2), is(matrixWas2));
	}
	@Test
	public void isColAndRowFillZeroTest(){
		Chap1 c = new Chap1();
		int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] was1 = {{1,2,3},{4,5,6},{7,8,9}};
		assertThat(c.isColAndRowFillZero(matrix1), is(was1));

		int[][] matrix2 = {{1,2,0},{4,5,6},{7,8,9}};
		int[][] was2 = {{0,0,0},{4,5,0},{7,8,0}};
		assertThat(c.isColAndRowFillZero(matrix2), is(was2));

		int[][] matrix3 = {{1,2,0},{4,0,6},{0,8,9}};
		int[][] was3 = {{0,0,0},{0,0,0},{0,0,0}};
		assertThat(c.isColAndRowFillZero(matrix3), is(was3));
	}
	@Test
	public void isSubstringTest(){
		Chap1 c = new Chap1();
		assertTrue(c.isSubstring("test", "t"));
		assertTrue(!c.isSubstring("test", "toooooo"));
		assertTrue(c.isSubstring("waterbottlewaterbottlewaterbottle", "erbottlewat"));
	}
	@Test
	public void isSpinString(){
		Chap1 c = new Chap1();
		String s1 = "test";
		String e1 = "estt";
		assertTrue(c.isSpinString(s1, e1));


		String s2 = "test";
		String e2 = "es";
		assertFalse(c.isSpinString(s2, e2));

		String s3 = "waterbottle";
		String e3 = "erbottlewat";
		assertTrue(c.isSpinString(s3, e3));
	}
}
