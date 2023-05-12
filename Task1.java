package task1cw;

import java.util.Arrays;

public class task1 {
	public static void main(String[] args) {
		char[] inputCharacters = {'o', 'o', 'm', 'm', 'a', 'a', 'r', 'r'};
		Arrays.sort(inputCharacters);
		char[] result = new char[inputCharacters.length];
		int k = 0;
		
		for (char i = 0; i < inputCharacters.length - 1; i++) {
			if (inputCharacters[i] != inputCharacters[i + 1]) {
				result[k++] = inputCharacters[i];
			}
		}
		result[k++] = inputCharacters[inputCharacters.length - 1];
		for (char i = 0; i < k; i++) {
			System.out.print(result[i]);
		}
	}
}