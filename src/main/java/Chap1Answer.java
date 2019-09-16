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
	// 1-5
	public boolean oneEditAway(String first, String second){
		if(first.length() == second.length()){
			return oneEditReplace(first,second);
		}else if(first.length() + 1 == second.length()){
			return oneEditInsert(first, second);
		}else if(first.length() - 1 == second.length()){
			return oneEditInsert(second, first);
		}
		return false;
	}
	public boolean oneEditReplace(String s1, String s2){
		boolean foundDifference = false;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(foundDifference){
					return false;
				}
				foundDifference = true;
			}
		}
		return true;
	}
	public boolean oneEditInsert(String s1, String s2){
		int index1 = 0;
		int index2 = 0;
		while(index2<s2.length() && index1 < s1.length()){
			if(s1.charAt(index1) != s2.charAt(index2)){
				if(index1 != index2){
					return false;
				}
				index2++;
			}else{
				index1++;
				index2++;
			}
		}
		return true;
	}
	// 1-6
	public String compress(String str){
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for(int i=0;i<str.length();i++){
			countConsecutive++;

			if(i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)){
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString(): str;
	}
	// 1-7
	public boolean rotate(int[][] matrix){
		if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
		int n = matrix.length;
		for(int layer = 0;layer < n / 2;layer++){
			int first = layer;
			int last = n - 1 - layer;
			for(int i = first;i<last;i++){
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] = matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
		return true;
	}
	// 1-8
	public void setZeros(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(matrix[i][j] == 0){
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for(int i=0;i<row.length;i++){
			if(row[i]) nullifyRow(matrix, i);
		}
		for(int j=0;j<column.length;j++){
			if(column[j]) nullifyColumn(matrix, j);
		}
	}
	public void nullifyRow(int[][] matrix, int row){
		for(int j=0;j<matrix[0].length;j++){
			matrix[row][j] = 0;
		}
	}
	public void nullifyColumn(int[][] matrix, int col){
		for(int i=0;i<matrix.length;i++){
			matrix[i][col] = 0;
		}
	}
	// 1-9
	public boolean isRotation(String s1, String s2){
		Chap1 c = new Chap1();
		int len = s1.length();
		if(len == s2.length() && len > 0){
			String s1s1 = s1 + s1;
			return c.isSubstring(s1s1, s2);
		}
		return false;
	}
}
