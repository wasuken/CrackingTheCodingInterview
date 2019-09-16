package chap1;

// 写経コード
class Chap1Answer{
	// 1-1
	public boolean isUniqueChars(String str){
		if(str.length() > 128) return false;
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
	// 1-2
	public String sort(String s){
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	public boolean permutation(String s, String t){
		if (s.length() == t.length()){
			return false;
		}
		return sort(s).equals(sort(t));
	}
	// 1-3
	public void replaceSpaces(char[] str, int trueLength){
		int spaceCount = 0, index, i = 0;
		for(i = 0;i < trueLength; i++){
			if(str[i] == ' '){
				spaceCount++;
			}
		}
		index = trueLength + spaceCount * 2;
		if(trueLength < str.length) str[trueLength] = '\0';
		for(i = trueLength - 1;i >= 0; i--){
			if(str[i] == ' '){
				str[index - 1] = '0';
				str[index - 2] = '2';
				str[index - 3] = '%';
				index -= 3;
			}else{
				str[index - 1] = str[i];
				index--;
			}
		}
	}
	// 1-4
	public boolean isPermulationOfPalindrome(String phrase){
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}
	public boolean checkMaxOneOdd(int[] table){
		boolean foundOdd = false;
		for(int count : table){
			if(count % 2 == 1){
				if(foundOdd){
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	public int getCharNumber(Character c){
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z){
			return val - a;
		}
		return -1;
	}
	public int[] buildCharFrequencyTable(String phrase){
		int[] table = new int[Character.getNumericValue('z') -
							  Character.getNumericValue('a') + 1];
		for(char c: phrase.toCharArray()){
			int x = getCharNumber(c);
			if(x != -1){
				table[x]++;
			}
		}
		return table;
	}
}
