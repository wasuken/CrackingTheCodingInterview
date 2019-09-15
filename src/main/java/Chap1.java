package Chap1;
import java.util.*;

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

	}
	// 写経コード
	public boolean isUniqueChars(String str){
		if (str.length() > 128) return false;
		boolean[] char_set = new boolean[128];
		for(int i = 0;i < str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
}
