package chap1;
import java.util.*;

// 自分の回答コード

public class Chap1{
	// 1-1
	public boolean noDuplicate(String s){
		char[] chs = s.toCharArray();
		Arrays.sort(chs);

		for(int i=0;i < chs.length - 1;i++){
			if(chs[i] == chs[i + 1]){
				return false;
			}
		}
		return true;
	}
	// 1-2
	public boolean orderCheck(String a, String b){
		char[] achars = a.toCharArray();
		char[] bchars = b.toCharArray();
		Arrays.sort(achars);
		Arrays.sort(bchars);
		String aSorted = String.valueOf(achars);
		String bSorted = String.valueOf(bchars);
		return aSorted.equals(bSorted);
	}
	// 1-3
	public String replaceSpace(String s){
		return s.replaceAll(" ", "%20");
	}
	// 1-4
	public boolean isPalindrome(String s){
		for(int i = 0; i < Math.ceil(s.length() / 2); i++){
			if(s.toCharArray()[i] != s.toCharArray()[s.length() - i - 1]) return false;
		}
		return true;
	}
	// 1-5
	public boolean isOneShotEqual(String a, String b){
		if(a.equals(b)) return true;
		int notEqCnt = 0;
		if(a.length() == b.length()){
			for(int i=0;i<a.length();i++){
				if(!(a.toCharArray()[i] == b.toCharArray()[i])){
					notEqCnt++;
					if(notEqCnt > 1){
						return false;
					}
				}
			}
			return true;
		}else if(Math.abs(a.length() - b.length()) == 1){
			String less = "";
			String greater = "";
			if(a.length() > b.length()){
				less = b;
				greater = a;
			}else{
				less = a;
				greater = b;
			}
			for(int i=0;i<greater.length();i++){
				if(less.length() <= i && notEqCnt <= 0) return true;
				if(!(greater.toCharArray()[i] == less.toCharArray()[i-notEqCnt])){
					notEqCnt++;
					if(notEqCnt > 1){
						return false;
					}
				}
			}
		}
		return true;
	}
	// 1-6
	public String stringCompression(String s){
		if(s.length() <= 0) return "";
		String result = "";
		String temp = "";
		for(char c : s.toCharArray()){
			if(temp.length() <= 0 || temp.toCharArray()[0] == c){
				temp += c;
			}else{
				result += "" + temp.toCharArray()[0] + temp.length();
				temp = "" + c;
			}
		}
		if(temp.length() > 0){
			result += "" + temp.toCharArray()[0] + temp.length();
		}
		return result;
	}
	// 1-7
	public int[][] spinMatrix(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] resultMatrix = new int[n][m];
		for(int i=0;i < n;i++){
			for(int j=0;j < m;j++){
				resultMatrix[i][j] = matrix[n-j-1][i];
			}
		}
		return resultMatrix;
	}
}
